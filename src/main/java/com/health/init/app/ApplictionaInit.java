package com.health.init.app;

import org.apache.log4j.PropertyConfigurator;

public class ApplictionaInit {

    /**
     * 初始化logger
     */
    public static void initLogger() {
        PropertyConfigurator.configure(ApplictionaInit.class.getResource("log4j.properties"));
    }

}
