package com.mahesh.springbootsample.rest;

public class bookmarkvalidationexception  extends RuntimeException{
	
	 public bookmarkvalidationexception(String userid){
		 
		 super("Could not find user " + userid);
	 }

}
