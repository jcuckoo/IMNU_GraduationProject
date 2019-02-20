package cn.com.cyxt.web.listener;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.collect.Sets;

import cn.com.cyxt.web.entity.Menu;
import cn.com.cyxt.web.entity.MenuType;
import cn.com.cyxt.web.service.IMenuService;
import cn.com.cyxt.web.service.IMenuTypeService;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.core.page.SimplePage;
import cn.com.lhd.core.sort.Sorter;


/**
 * 
 * @desc 初始化容器监听器
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:28:06
 */
public class ContainerListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
		
		// 菜系类别归档
		IMenuTypeService iMenuTypeService = (IMenuTypeService) applicationContext.getBean("menuTypeServiceImpl");
		List<MenuType> menuTypeCountList = iMenuTypeService.queryWithMenuCount();
		application.setAttribute("menuTypeCountList", menuTypeCountList);
		
		// 菜单排行
		IMenuService iMenuService = (IMenuService) applicationContext.getBean("menuServiceImpl");
		Set<ISort> sortSet = Sets.newHashSet(new Sorter("buy_count", false));
		IPage page = new SimplePage(1, 10);
		List<Menu> hotMenuList = iMenuService.queryList(null, null, sortSet, page);
		application.setAttribute("hotMenuList", hotMenuList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
}
