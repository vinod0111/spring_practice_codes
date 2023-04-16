package com.practice.rest_template_practice;

import com.practice.rest_template_practice.resttemplate.RestTemplateBeanCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplatePracticeApplication {

//	@Autowired
//	RestTemplateBeanCreation _restTemplateBeanCreation;
	public static void main(String[] args) {

//		SpringApplication.run(RestTemplatePracticeApplication.class, args);

		ApplicationContext applicationContext = SpringApplication.run(RestTemplatePracticeApplication.class, args);

		RestTemplateBeanCreation restTemplateBeanCreation = applicationContext.getBean(RestTemplateBeanCreation.class);

		restTemplateBeanCreation.fetchData();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
