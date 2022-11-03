package com.joohee.portfolio.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class JndiResource {
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatWebServer(tomcat);
			}
			
			@Override
			protected void postProcessContext(Context context) {
				context.getNamingResources().addResource(getResource());
			}
		};
	}
	
	public ContextResource getResource() {
		ContextResource resource = new ContextResource();
		resource.setName("jndi/portfolio"); // 사용될 jndi 이름
		resource.setType("javax.sql.DataSource");
		resource.setAuth("Container");
		resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
		
		// datasource 정보
		resource.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
		resource.setProperty("url", "jdbc:mysql://localhost:3307/portfolio?serverTimezone=UTC");
		resource.setProperty("username", "root");
		resource.setProperty("password", "root!");
		
		return resource;
	}
	
	@Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSession) {
        return new SqlSessionTemplate(sqlSession);
    }
	
}