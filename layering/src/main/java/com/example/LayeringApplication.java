package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@SpringBootApplication
public class LayeringApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		customerService.save(new Customer(1, "nobita", "nobi"));
		customerService.save(new Customer(2, "takeshi", "goda"));
		customerService.save(new Customer(3, "suneo", "hokawa"));
		
		customerService.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LayeringApplication.class, args);
	}
}