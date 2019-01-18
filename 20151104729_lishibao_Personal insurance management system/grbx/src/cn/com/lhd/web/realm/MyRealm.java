package cn.com.lhd.web.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.service.IUserService;
import cn.com.lhd.web.utils.BlankUtil;
import cn.com.lhd.web.utils.SysProperties;

/**
 * 
 * @desc 自定义Realm(Shiro需要)
 *
 * @author luohaidian
 * @date 2018年11月28日
 * @time 下午8:17:08
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 身份校验
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = iUserService.queryByUserName(username);
		if (!BlankUtil.isBlank(user)) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "123456");
			// 当前用户信息存到session中
			SecurityUtils.getSubject().getSession().setAttribute(SysProperties.CURRENTUSER, user);
			return authcInfo;
		}
		return null;
	}

}
