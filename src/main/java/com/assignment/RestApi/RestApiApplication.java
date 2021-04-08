package com.assignment.RestApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.assignment"})
public class RestApiApplication extends SpringBootServletInitializer 
{

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder 
application) {
   return application.sources(RestApiApplication.class);
  }

 public static void main(String[] args) throws Exception {
   SpringApplication.run(RestApiApplication.class, args);
     }
 
 @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/*
	 * @Bean public CommandLineRunner run(RestTemplate restTemplate) throws
	 * Exception { return args -> { Quote quote = restTemplate.getForObject(
	 * "https://quoters.apps.pcfone.io/api/random", Quote.class);
	 * log.info(quote.toString()); }; }
	 */

}

/*
 * @SpringBootApplication public class RestApiApplication {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(RestApiApplication.class, args); }
 * 
 * }
 */
