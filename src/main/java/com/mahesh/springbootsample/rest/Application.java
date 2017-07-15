package com.mahesh.springbootsample.rest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mahesh.springbootsample.model.Account;
import com.mahesh.springbootsample.model.AccountRepository;
import com.mahesh.springbootsample.model.Bookmark;
import com.mahesh.springbootsample.model.Bookmarkrespository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.mahesh.springbootsample.model"})
@EntityScan(basePackages = {"com.mahesh.springbootsample.model"})
@ComponentScan(basePackages = {"com.mahesh.springbootsample.model"})
@Configuration

public class Application {
	
	 public static void main(String[] args){
		 
		 SpringApplication springApplication = new SpringApplication();
		 ApplicationContext applicationContext = springApplication.run(Application.class,args);

		 }
	 

		@Bean
		CommandLineRunner init(AccountRepository accountrepository, Bookmarkrespository bookmarkrepositroy){
			
			return (evt)-> Arrays.asList("caty,dogy,caty1,dogy1".split(",")).forEach(a ->{
				
				System.out.println("saved accounts to table...");
				
				Account account = accountrepository.save(new Account(a, "password"));
				
				bookmarkrepositroy.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
				bookmarkrepositroy.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
				
			});
		}
}
