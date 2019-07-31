package com.liyibo1110.gemsshop.store.manager.server.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {

	@Bean(name="gemsShopDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.gemsshop")
	public DataSource gemsShopDataSource(){
	    return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
	}
	
	@Bean(name="gemsShopSessionFactory")
    public SqlSessionFactory gemsShopSessionFactory(@Qualifier("gemsShopDataSource") DataSource gemsShopDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(gemsShopDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/liyibo1110/gemsshop/store/manager/server/mapper/*.xml"));
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        return factoryBean.getObject();
    }
	
	@Bean(name="gemsShopSqlSessionTemplate")
    public SqlSessionTemplate gemsShopSqlSessionTemplate(@Qualifier("gemsShopSessionFactory") SqlSessionFactory gemsShopSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(gemsShopSessionFactory); 
        return template;
    }
	
}
