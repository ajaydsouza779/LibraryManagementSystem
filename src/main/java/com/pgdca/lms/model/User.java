package com.pgdca.lms.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class User {

	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	//@UniqueElements(message = "Name already exists")
    private String username;
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
   
    private Boolean isApproved;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Collection<Role> roles;

    @ManyToMany
    private Collection<Book> issuedBooks;

    @ManyToMany
    private Collection<Book> requestedBooks;
    
    @ManyToMany
    private Collection<Book> returnBooks;

	
	  @Override public String toString() { 
		  
		  return getClass().getName() + "@" + Integer.toHexString(hashCode());
	  
	  }
	 
 
}
