Spring @MVC 3.1 Java config
================================

A simple example that uses Spring's Java configuration instead of XML.

This is a fake login app. In real life you'd probably use Spring Security instead.

There is a service and data access layer, but the repository is just a hard coded stub. It would be 
simple to modify this to use Spring Data. (See next blog...)

The JSP pages are written in HTML5. The pages use [http://twitter.github.com/bootstrap/] (Twitter Bootstrap)
for layout and CSS styling. Take a look at the login form and you won't see the typical table tags
used for layout. For compatibility with older browsers, [http://modernizr.com/](Modernizr) is used.

This project also ses the Servlet 3.0 ability to replace web.xml

Maven
------
The pom.xml requires Maven 3. Some dependencies/plugins aren't needed in this project (e.g. the persistence libraries) but are
there for easy migration.

You can run the project with Jetty. The Tomcat 7 plugin is a bit flaky, but the "real" Tomcat 7 works fine.

>	mvn jetty:run


Resources
----------
- [http://static.springsource.org/spring/docs/current/spring-framework-reference/html](http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html)
- [http://static.springsource.org/spring/docs/current/spring-framework-reference/html/beans.html#beans-java](http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/beans.html#beans-java)
- [http://maven.apache.org](http://maven.apache.org)
- [http://jcp.org/en/jsr/detail?id=315](Servlet 3.0 spec)
- [http://twitter.github.com/bootstrap/] (Twitter Bootstrap)
- [http://modernizr.com/](Modernizr)


