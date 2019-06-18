package com.pgdca.lms.model;

import org.springframework.beans.support.PagedListHolder;

import lombok.Data;

@Data
public class PgLists {
	public PgLists(String bookCatetgory, String listName,  PagedListHolder pagedListHolderByCategory) {
		this.listName = listName;
		this.listVal = pagedListHolderByCategory;
		this.category = category;
	}
	private String category;
	private String listName;
	private PagedListHolder<Book> listVal;
	
}
