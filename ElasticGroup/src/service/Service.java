package service;

import javax.servlet.http.HttpServletRequest;

import bean.BeanBrowser;

public class Service {
	
	public static BeanBrowser getSessionBeanBrowser(HttpServletRequest request) {
		return ((BeanBrowser) request.getSession().getAttribute("beanBrowser"));
	}
}
