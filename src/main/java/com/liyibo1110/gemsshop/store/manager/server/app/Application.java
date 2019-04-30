package com.liyibo1110.gemsshop.store.manager.server.app;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.unit.DataSize;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.liyibo1110.gemsshop.store.manager.server.config.EnvConfig;

/**
 * 
 * @author liyibo
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.liyibo1110.gemsshop.store.manager.server"})
@EnableConfigurationProperties({EnvConfig.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*");  
        corsConfiguration.addAllowedHeader("*");  
        corsConfiguration.addAllowedMethod("*");  
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;  
    }
	
	/** 
	* 跨域过滤器
     * @return 
     */  
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig());  
        return new CorsFilter(source);  
    } 
    
    /**  
     * 文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize(DataSize.ofMegabytes(2));
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize(DataSize.ofMegabytes(20));  
        return factory.createMultipartConfig();  
    } 

}
