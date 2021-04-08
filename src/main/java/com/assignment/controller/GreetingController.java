package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.ob.Greeting;
import com.assignment.ob.OBPost;
import com.assignment.thirdparty.TypiCodeApi;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/greeting/testapi")
	public String testapi(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		RestTemplate restTemplate = new RestTemplate();
		 
		String url = "https://jsonplaceholder.typicode.com/posts";
		
	    String result = restTemplate.getForObject(url, String.class);
	    System.out.println(result);
		
		
		return result;
	}
}
