package com.rockhoppertech.mvc.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration classes =~ <beans/> xml documents
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.rockhoppertech.mvc.service",
		"com.rockhoppertech.mvc.repositories.internal" })
public class RootConfig {

	// @Bean methods ~= <bean/> elements

}