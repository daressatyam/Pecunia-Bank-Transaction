package com.capgemini.pecunia.bank.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * Interceptors has the ability to pre-handle and post-handle the web requests. Each interceptor class should extend the HandlerInterceptor class.
 *  Here we will create a Logger Interceptor by extending the HandlerInterceptor class.
 * 
 * 
 */

@Component
public class LoggerInterceptor implements HandlerInterceptor{
	/*this method is invoked before sending the response
	 * the preHandle() method will be called before handling the request
	 * the postHandle() method will be called after handling the request and 
	 * the afterCompletion() method will be called after rendering the view.
	 */
	Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse arg1, Object obj, Exception arg3)
			throws Exception {
		HandlerMethod mtd =(HandlerMethod)obj;
		
		logger.debug( "Sending the Response  to the browser for the URI " + req.getRequestURI());
	}

	//this method is invoked after accessing the controller
	@Override
	public void postHandle(HttpServletRequest req, 	HttpServletResponse arg1, Object obj, ModelAndView mv)
			throws Exception {
		HandlerMethod mtd =(HandlerMethod)obj;
		String str = mtd.getMethod().getName() + " method of " + mtd.getBean().getClass().getSimpleName() ;
		
		logger.debug(str + " is executed and forwarding  for the URI " + req.getRequestURI());
	}

	//this method is invoked before accessing the controller
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object obj) throws Exception {
		HandlerMethod mtd =(HandlerMethod)obj;
		String str = mtd.getMethod().getName() + " method of " + mtd.getBean().getClass().getSimpleName() ;
		logger.debug("It is invoking the " + str + "for the URI " +req.getRequestURI());
		return true;
	}

}

