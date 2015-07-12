package com.enation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.enation.core.action.newsAction;

public class NewsHttpSessionListener implements HttpSessionListener,ServletRequestListener//, ServletContextListener
{
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("NewsSession Create");
		
//		sessionDestroyed(arg0);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("NewsSession Destoryed");
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		HttpServletRequest hsr = (HttpServletRequest)arg0.getServletRequest();
		
		System.out.println(hsr.getRequestURI());
		System.out.println("request des");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("request init");
	}

//	@Override
//	public void contextDestroyed(ServletContextEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void contextInitialized(ServletContextEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}

	
	

	

	

}
