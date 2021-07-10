package com.example.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingdatamongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingdatamongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		//Save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		//Fetch all customers
		System.out.println("Customers found with findALl():");
		System.out.println("_______________________________");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		//Fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("_____________________________________________");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("_____________________________________________");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}
