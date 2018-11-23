package cn.com.lhd.core.interceptor;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.utils.BlankUtil;

/**
 * 排序与翻页插件
 * 实现排序Mapper接口方法参数列表需包含： @Param("sorts")Collection<ISort> sorts
 * 实现翻页Mapper接口方法参数列表需包含： @Param("page")IPage page
 */
@Intercepts(
        {
                @Signature(
                        method = "query",
                        type = Executor.class,
                        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
                )
        }
)
public class PageInterceptor implements Interceptor {

	//翻页参数标识  @Param("page")
    private static final String PAGE_LABEL = "page";
    
    //排序集标识   @Param("sorts")
    private static final String SORT_LABEL = "sorts";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] methodArgs = invocation.getArgs();
        MappedStatement ms = (MappedStatement) methodArgs[0];
        Object paramObject = methodArgs[1];
        if (paramObject instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) paramObject;
            Object pageObject = paramMap.containsKey(PAGE_LABEL) ? paramMap.get(PAGE_LABEL) : null;
            Object sortObject = paramMap.containsKey(SORT_LABEL) ? paramMap.get(SORT_LABEL) : null;
            String newSql = "";
            if (sortObject instanceof Collection) {
                newSql += buildSortSql((Collection<ISort>) sortObject);
            }
            if (pageObject instanceof IPage) {
                newSql += buildPageSql((IPage) pageObject);
            }
            if (!newSql.isEmpty()) {
                BoundSql boundSql = ms.getBoundSql(paramObject);
                newSql = boundSql.getSql() + newSql;
                BoundSql newBoundSql = createBoundSql(ms.getConfiguration(), boundSql, newSql);
                methodArgs[0] = createMappedStatement(ms, (po) -> newBoundSql);
            }
        }
        return invocation.proceed();
    }

    /**
     * 构建排序部分语句
     *
     * @param sorts 排序集合
     * @return ORDER BY .....
     */
    private String buildSortSql(Collection<ISort> sorts) {
        if (sorts.isEmpty()) {
            return "";
        }
        Set<String> set = Sets.newHashSetWithExpectedSize(sorts.size());
        for (ISort iSort : sorts) {
            set.add(iSort.getField() + (iSort.isAsc() ? " ASC" : " DESC"));
        }
        return " ORDER BY " + Joiner.on(",").join(set);
    }

    /**
     * 构建分页部分语句
     *
     * @param page 分页
     * @return LIMIT ... OFFSET
     */
    private String buildPageSql(IPage page) {
        StringBuilder sql = new StringBuilder();
        if (!BlankUtil.isBlank(page.getPageSize())) {
            sql.append(" LIMIT ").append(page.getPageSize());
        }
        if (!BlankUtil.isBlank(page.getPageNo())) {
            int offset = (page.getPageNo() - 1) * page.getPageSize();
            sql.append(" OFFSET ").append(offset);
        }
        return sql.toString();
    }

    /**
     * 构建BoundSql
     *
     * @param configuration 配置
     * @param orgBoundSql   原绑定sql
     * @param newSql        新sql语句
     * @return BoundSql
     */
    private BoundSql createBoundSql(Configuration configuration, BoundSql orgBoundSql, String newSql) {
        List<ParameterMapping> parameterMappings = orgBoundSql.getParameterMappings();
        BoundSql boundSql = new BoundSql(configuration, newSql, parameterMappings, orgBoundSql.getParameterObject());
        for (ParameterMapping pm : parameterMappings) {
            String prop = pm.getProperty();
            if (orgBoundSql.hasAdditionalParameter(prop)) {
                boundSql.setAdditionalParameter(prop, orgBoundSql.getAdditionalParameter(prop));
            }
        }
        return boundSql;
    }

    /**
     * 构建MappedStatement
     *
     * @param orgMappedStatement 原MappedStatement对象
     * @param sqlSource          sql源
     * @return MappedStatement
     */
    private MappedStatement createMappedStatement(MappedStatement orgMappedStatement, SqlSource sqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(orgMappedStatement.getConfiguration(),
                orgMappedStatement.getId(), sqlSource, orgMappedStatement.getSqlCommandType());
        builder.resource(orgMappedStatement.getResource());
        builder.fetchSize(orgMappedStatement.getFetchSize());
        builder.statementType(orgMappedStatement.getStatementType());
        builder.keyGenerator(orgMappedStatement.getKeyGenerator());
        String[] keyProperties = orgMappedStatement.getKeyProperties();
        if (!BlankUtil.isBlank(keyProperties)) {
            builder.keyProperty(Joiner.on(',').join(orgMappedStatement.getKeyProperties()));
        }
        builder.timeout(orgMappedStatement.getTimeout());
        builder.parameterMap(orgMappedStatement.getParameterMap());
        builder.resultMaps(orgMappedStatement.getResultMaps());
        builder.resultSetType(orgMappedStatement.getResultSetType());
        builder.cache(orgMappedStatement.getCache());
        builder.flushCacheRequired(orgMappedStatement.isFlushCacheRequired());
        builder.useCache(orgMappedStatement.isUseCache());
        return builder.build();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
