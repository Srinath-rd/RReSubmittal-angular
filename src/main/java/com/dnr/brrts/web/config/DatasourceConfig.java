package com.dnr.brrts.web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class DatasourceConfig {

    //    @Primary
//    @Bean(name="devDataSource")
//    @(prefix="spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
    @Value("${spring.datasource.primary.jndi-name}")
    private String primaryJndiName;

    @Value("${spring.datasource.gis.jndi-name}")
    private String gisJndiName;
//
//
    @Primary
    @Bean(name = "devDataSource", destroyMethod = "")
    public DataSource dataSource(){
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource(primaryJndiName);
    }


    @Bean(name = "gisDataSource", destroyMethod = "")
    public DataSource gisSataSource(){
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource(gisJndiName);
    }

    @Bean(name = "primaryJdbcTemplate")
    @Autowired
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("devDataSource") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }

    @Bean(name = "gisJdbcTemplate")
    @Autowired
    public JdbcTemplate gisJdbcTemplate(@Qualifier("gisDataSource") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }


}
