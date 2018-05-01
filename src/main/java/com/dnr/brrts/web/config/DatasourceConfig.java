package com.dnr.brrts.web.config;


import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
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

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        return new TomcatEmbeddedServletContainerFactory() {

            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
                    Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/RReSubmittal");
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
                resource.setProperty("url", "jdbc:oracle:thin:@ora-od016.enterprise.wistate.us:20402:od016");
                resource.setProperty("username", "pullas");
                resource.setProperty("password", "rss(DQP5");

                ContextResource resource1 = new ContextResource();
                resource1.setName("jndi/RReSubmittalSDE");
                resource1.setType(DataSource.class.getName());
                resource1.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
                resource1.setProperty("url", "jdbc:oracle:thin:@ora-od018.enterprise.wistate.us:20402:od018");
                resource1.setProperty("username", "S71584");
                resource1.setProperty("password", "rronsde");

                ContextResource resource2 = new ContextResource();
                resource2.setName("jndi/RReSubmittalSDERR");
                resource2.setType(DataSource.class.getName());
                resource2.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
                resource2.setProperty("url", "jdbc:oracle:thin:@ora-od018.enterprise.wistate.us:20402:od018");
                resource2.setProperty("username", "S71584");
                resource2.setProperty("password", "rronsde");

                context.getNamingResources().addResource(resource);
                context.getNamingResources().addResource(resource1);
                context.getNamingResources().addResource(resource2);
            }
        };
    }

    @Primary
    @Bean(name = "devDataSource", destroyMethod = "")
    public DataSource dataSource() throws NamingException {
//        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//        return dataSourceLookup.getDataSource(primaryJndiName);
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/jdbc/RReSubmittal");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource)bean.getObject();
    }


    @Bean(name = "gisDataSource", destroyMethod = "")
    public DataSource gisSataSource() throws NamingException {
//        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//        return dataSourceLookup.getDataSource(gisJndiName);
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/jndi/RReSubmittalSDE");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource)bean.getObject();
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
