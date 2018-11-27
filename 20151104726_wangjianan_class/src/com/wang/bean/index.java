package com.wang.bean;

import java.util.List;




public class IndexAction extends ActionSupport {
	
	private AclManager aclManager;
	
	public AclManager getAclManager() {
		return aclManager;
	}

	@Resource
	public void setAclManager(AclManager aclManager) {
		this.aclManager = aclManager;
	}
	
	public String outlook() throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("login");
		List modules = aclManager.searchModules(user.getId());
		ActionContext.getContext().put("modules", modules);
		return "outlook";
	}
	
	public String main() throws Exception {
		return "main";
	}
}
