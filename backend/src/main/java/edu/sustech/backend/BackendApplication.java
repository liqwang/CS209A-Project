package edu.sustech.backend;

import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("edu.sustech.backend.dao")
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//		tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
//		return tomcat;
//	}
//
//	private Connector createHTTPConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		//同时启用http（8080）、https（8443）两个端口
//		connector.setScheme("http");
//		connector.setSecure(false);
//		connector.setPort(8080);
//		connector.setRedirectPort(8443);
//		return connector;
//	}
}
