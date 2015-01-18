package com.robert.rest.controllers;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Class registers itself with application container to receive life cycle for the servlet.
 */
@Component
public class ApplicationContextListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        logger.info("Destroying MediaGateway ServletContext");

        ILoggerFactory factory = LoggerFactory.getILoggerFactory();
        if(factory instanceof LoggerContext) {
            logger.info("Destroy logger context");
            LoggerContext ctx = (LoggerContext)factory;
            ctx.stop();
        }
        logger.info("MediaGateway ServletContext destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        logger.info("MediaGateway ServletContext initialized");
    }

}
