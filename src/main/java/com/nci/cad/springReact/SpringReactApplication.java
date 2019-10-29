package com.nci.cad.springReact;

//import com.nci.cad.springReact.config.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(DBConfig.class)
public class SpringReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactApplication.class, args);
	}

}
