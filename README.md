Spring @MVC 3.1 Java config
================================

This is a simple example that uses Spring's Java configuration instead of XML.
This example is explained in my [blog post](http://rockhoppertech.com/blog/spring-mvc-configuration-without-xml).

This is a fake login app. In real life you'd probably use Spring Security instead.

There is a service and data access layer, but the repository is just a hard coded stub. It would be 
simple to modify this to use Spring Data. (See next blog...)

The JSP pages are written in HTML5. The pages use [Twitter Bootstrap] (http://twitter.github.com/bootstrap/)
for layout and CSS styling. Take a look at the login form and you won't see the typical table tags
used for layout. For compatibility with older browsers, [Modernizr](http://modernizr.com/) is used.

This project also ses the Servlet 3.0 ability to replace web.xml

Maven
------
The pom.xml requires Maven 3. Some dependencies/plugins aren't needed in this project (e.g. the persistence libraries) but are
there for easy migration.

You can run the project with Jetty. The Tomcat 7 plugin is a bit flaky, but the "real" Tomcat 7 works fine.

>	mvn jetty:run

The site plugin with several reporting plugins is also configured. Take a look at src/site.

>   mvn site


Resources
----------
- [blog post for this example](http://rockhoppertech.com/blog/spring-mvc-configuration-without-xml) "Blog"
- [Spring Reference](http://static.springsource.org/spring/docs/current/spring-framework-reference/html)
- [Spring Java-based container configuration](http://static.springsource.org/spring/docs/current/spring-framework-reference/html/beans.html#beans-java)
- [Maven](http://maven.apache.org) "Maven"
- [Servlet 3.0 spec](http://jcp.org/en/jsr/detail?id=315) "Servlet spec"
- [Twitter Bootstrap] (http://twitter.github.com/bootstrap/) "Bootstrap"
- [Modernizr](http://modernizr.com/) "Modernizr"


