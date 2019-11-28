package com.example.demo1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo1.entity.Country;
import com.example.demo1.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Demo1Application {

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class, args);
		Demo1Application application = context.getBean(Demo1Application.class);
		application.start();
		context.close();
	}

	private void start() {
		Country country = countryService.getByCode("FR");
		log.info("-> {}", country);
	}

	@PostConstruct
	private void init() {
		countryService.saveFromCsv("src/main/resources/countries.csv");
	}
}
