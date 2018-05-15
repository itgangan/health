package com.health.init.app;

import com.health.util.PropertiesUtils;

import java.util.Properties;

/**
 * 系统配置常量
 *
 * @author health
 */
public class SystemConstans {

    public static final String CONFIG_PATH;
    public static final String APP_NAME;
    public static final String UPLOAD_TEMP;

    static {
        CONFIG_PATH = getConfigPath();

        String path = CONFIG_PATH + "/config.properties";
        Properties p = PropertiesUtils.loadProperties(path);

        APP_NAME = p.getProperty("appName");
        UPLOAD_TEMP = p.getProperty("uploadTemp");

    }

    // 初始化配置文件路径
    private static String getConfigPath() {
        String configPath = "/etc/learn/";
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            configPath = "D:/" + configPath;
        }
        return configPath;
    }
}
