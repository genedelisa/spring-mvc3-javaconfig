package com.rockhoppertech.mvc.web.config;

import java.util.Set;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Servlet 3.0 replacement for web.xml
 * 
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory
			.getLogger(WebAppInitializer.class);

	/**
	 * 
	 * 
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 *      .ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		// Create the root appcontext
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);

		// if you're not passing in the config classes to the constructor,
		// refresh
		rootContext.refresh();

		// Manage the lifecycle of the root appcontext
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		// now the config for the Dispatcher servlet
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(WebMvcConfig.class);

		// Filters
		// http://static.springsource.org/spring/docs/3.1.x/javadoc-api/org/springframework/web/filter/package-summary.html

		// Enables support for DELETE and PUT request methods with web browser
		// clients
		// http://static.springsource.org/spring/docs/3.1.x/javadoc-api/org/springframework/web/filter/HiddenHttpMethodFilter.html

		FilterRegistration.Dynamic fr = servletContext.addFilter(
				"hiddenHttpMethodFilter", new HiddenHttpMethodFilter());
		fr.addMappingForUrlPatterns(null, true, "/*");

		fr = servletContext.addFilter("encodingFilter",
				new CharacterEncodingFilter());
		fr.setInitParameter("encoding", "UTF-8");
		fr.setInitParameter("forceEncoding", "true");
		fr.addMappingForUrlPatterns(null, true, "/*");

		// The main Spring MVC servlet.
		ServletRegistration.Dynamic appServlet = servletContext.addServlet(
				"appServlet", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = appServlet.addMapping("/");

		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				logger.error("Mapping conflict: " + s);
			}
			throw new IllegalStateException(
					"'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
		}

		this.logbackServlet(servletContext);
	}

	public void logbackServlet(ServletContext servletContext) {
		ServletRegistration.Dynamic servlet = servletContext.addServlet(
				"logbackStatus",
				new ch.qos.logback.classic.ViewStatusMessagesServlet());
		servlet.setLoadOnStartup(3);
		Set<String> mappingConflicts = servlet
				.addMapping("/admin/logbackStatus/*");

		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				logger.error("Mapping conflict: " + s);
			}
			throw new IllegalStateException("servlet cannot be mapped");
		}
	}

}
