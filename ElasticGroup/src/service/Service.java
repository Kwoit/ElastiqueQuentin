package service;

import javax.servlet.http.HttpServletRequest;

import bean.BeanBrowser;

public class Service {
	
	/**
	 * @param request
	 * @return Retourne le Browser Bean attaché a la session passé en parametre
	 */
	public static BeanBrowser getSessionBeanBrowser(HttpServletRequest request) {
		return ((BeanBrowser) request.getSession().getAttribute("beanBrowser"));
	}
}
