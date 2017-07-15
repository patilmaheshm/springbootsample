package com.mahesh.springbootsample.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	
	public Account(){
		
	}
	public Account(String username, String Password){
		this.username = username;
		this.password = Password;
		
	}
@Id
@GeneratedValue
 Long id; 	

  String username;
  
  @OneToMany(mappedBy="account")
  private Set<Bookmark> bookmarks = new HashSet<>();
  
  public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@JsonIgnore
String password;

public Set<Bookmark> getBookmarks() {
	return bookmarks;
}
public void setBookmarks(Set<Bookmark> bookmarks) {
	this.bookmarks = bookmarks;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
  
}
