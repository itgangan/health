package com.health.init.persistence;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://10.68.40.31:3306/health?useUnicode=true&amp;characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("");

        ds.setInitialSize(5);
        ds.setMaxIdle(10);
        ds.setMinIdle(1);
        ds.setMaxWaitMillis(30000);

        ds.setMaxWaitMillis(5000);
        ds.setRemoveAbandonedOnBorrow(true);
        ds.setRemoveAbandonedOnMaintenance(true);

        ds.setLogAbandoned(true);

        return ds;
    }
}
