package com.mahesh.springbootsample.rest;

import java.util.Collection;
import java.net.URI;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahesh.springbootsample.model.Account;
import com.mahesh.springbootsample.model.AccountRepository;
import com.mahesh.springbootsample.model.Bookmark;
import com.mahesh.springbootsample.model.Bookmarkrespository;



//package com.mahesh.springbootsample.rest;

@RestController
//@RequestMapping("/{username}/bookmark")
public class Bookmarkcontroller {
	
	@Autowired 
	private AccountRepository accountrepository;
	
	@Autowired
	private Bookmarkrespository bookmarkrepository;
	
	@RequestMapping(value= "/bookmarks", method = RequestMethod.GET)
	Collection<Bookmark> readBookmarks(){
		//this.validateuser(username);
		return this.bookmarkrepository.findAll();
		
	
	}
	
	@RequestMapping(value= "/accounts", method = RequestMethod.GET)
	Collection<Account> readAccounts(){
		//this.validateuser(username);
		return this.accountrepository.findAll();
		
	
	}
	
 @RequestMapping(value="/bookmarks/{userid}" ,method =  RequestMethod.POST)
 ResponseEntity<?> add(@PathVariable String userid, @RequestBody Bookmark input){
	    	
	      this.validateuser(userid);
	      
	      return this.accountrepository.findByUsername(userid)
	    	 .map( account -> {
	    	 Bookmark result =  this.bookmarkrepository.save(new Bookmark(account,input.url,input.description ));
	    	 

	    			 URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")       
						.buildAndExpand(result.getId()).toUri();

	            return  ResponseEntity.created(location).build();
	      }).orElse(ResponseEntity.noContent().build());
	    }
	
	public void validateuser(String username){
		
		this.accountrepository.findByUsername(username).orElseThrow(()-> new  bookmarkvalidationexception(username));
		
			
		}
	

}
