package com.health.init.app;

import com.health.util.ReflectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

public class ServerListener implements ServletContextListener {

	Logger logger = LoggerFactory.getLogger(ServerListener.class);
	public void contextInitialized(ServletContextEvent arg0) {

//		ApplictionaInit.initLogger();
//		logger.info("init logger succ.");
//
//		logger.info("-----SystemConstans start-----");
//		Map<String, Object> systemConstans = ReflectUtil.getFieldValue(SystemConstans.class);
//		for (Map.Entry<String, Object> entry : systemConstans.entrySet()) {
//			logger.info(entry.getKey() + "=" + entry.getValue());
//		}
//		logger.info("-----SystemConstans end-----");
//
//		logger.info("init finished");
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
}
