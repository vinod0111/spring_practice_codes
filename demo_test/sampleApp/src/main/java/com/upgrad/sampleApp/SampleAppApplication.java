package com.upgrad.sampleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class SampleAppApplication {

	public static void main(String[] args) {

		// SpringApplication.run(SampleAppApplication.class, args);

		ApplicationContext context = SpringApplication.run(SampleAppApplication.class, args);

		System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("myService"));
		// System.out.println("Welcome to spring sample application");
	}

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to spring sample application";
	}

}
