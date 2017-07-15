package com.mahesh.springbootsample.model;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookmarkrespository extends JpaRepository<Bookmark, Long>{
	
	
Collection<Bookmark> findByAccountUsername(String username);

}
