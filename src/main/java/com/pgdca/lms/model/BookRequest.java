package com.pgdca.lms.model;

import lombok.Data;

@Data
public class BookRequest {
	

	Long Id;
	
	public BookRequest() {
		
	}
	public BookRequest( Long bookId,  Long userId, String title, String user, String email, Boolean isUserApproved) {
		this.bookId = bookId;
		this.userId = userId;
		this.title = title;
		this.user = user;
		this.email = email;
		this.isUserApproved = isUserApproved;
	}
	private Long bookId;
	private Long userId;
	private String title;
	private String user;
	private String email;
	private boolean isRequested;
	private boolean isIssued;
	private Boolean isUserApproved;
	
}
