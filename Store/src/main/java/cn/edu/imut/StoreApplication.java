package cn.edu.imut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "cn.edu.imut"})
public class StoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
}
