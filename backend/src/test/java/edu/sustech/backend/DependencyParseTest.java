package edu.sustech.backend;

import edu.sustech.search.engine.github.analyzer.Analyzer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DependencyParseTest {
	@Test
	void dependencyParseTest() throws IOException {
//		String content = Files.readString(Path.of("src/main/resources/test.pom.xml"));
		String content= """
				        <dependency>
				            <groupId>com.alibaba</groupId>
				            <artifactId>dubbo</artifactId>
				            <exclusions>
				                <exclusion>
				                    <artifactId>slf4j-api</artifactId>
				                    <groupId>org.slf4j</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>log4j</artifactId>
				                    <groupId>log4j</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>commons-logging</artifactId>
				                    <groupId>commons-logging</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring-core</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring-expression</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring-aop</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring-core</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring-aop</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring-beans</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				                <exclusion>
				                    <artifactId>spring</artifactId>
				                    <groupId>org.springframework</groupId>
				                </exclusion>
				            </exclusions>
				        </dependency>
				""";
		System.out.println(Analyzer.parseDependency(content));
	}
}
