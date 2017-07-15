package com.mahesh.springbootsample.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookmark {

	
	public Bookmark(){
		
	}
	public Bookmark(Account account, String uri, String description){
		this.account =  account;
		this.url = uri;
		this.description =  description;
		
	}
	public String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String description;
	
	@JsonIgnore
	@ManyToOne
	Account account;
	
	@Id
	@GeneratedValue
	Long Id;
}
