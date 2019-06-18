package com.pgdca.lms.config;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pgdca.lms.model.Book;
import com.pgdca.lms.repository.BookRepository;

import ch.qos.logback.classic.Logger;

@Configuration
@Slf4j
public class LoadDatabase {

	@Autowired
	BookRepository bookRepository;

	/*
	@Bean
	InitializingBean initDatabase() { // BookRepository bookRepository
		return () -> {

			for (int i = 1; i <= 9; i++) {

				String imageName = "000000000" + i + ".jpg";
				
				String isin = i + 2 + "101" + i * 2;
				Float rate = (float) (i * 525.50);

				String title = "" ;
				String category = "";
				String synopsis = "";
				String author = "";
				
				if(i%2==0) {
					 title = "Narnia Epics" ;
					 category = "Comedy";
					 synopsis = "This book is the story that reveals human struggle for happiness.";
					 author = "K A Thakur";					
				} else {
					 title = "The Willows" ;
					 category = "Fiction";
					 synopsis = "Sci-Fi Adventure of the era.";
					 author = "Williams Jones";
				}
				if(i%3==0) {
					 title = "The Archer" ;
					 category = "Adventure";
					 synopsis = "The jungle trains a man whose skills we should be equiped with.";
					 author = "J A Poppins";					
				}
				if(i%5==0) {
					 title = "Jack & Jill" ;
					 category = "Children";
					 synopsis = "Story of kids.";
					 author = "Jackson Kim";					
				}if(i%6==0) {
					 title = "Romeo today" ;
					 category = "Romance";
					 synopsis = "Love Story.";
					 author = "Tom Care";					
				}

				
				
				bookRepository.save(new Book(isin, title, category, synopsis, author, rate, imageName));
			}

			for (int i = 10; i <= 99; i++) {

				String imageName = "00000000" + i + ".jpg";
				
				String isin = i + 2 + "101" + i * 2;
				Float rate = (float) (i * 525.50);

				String title = "" ;
				String category = "";
				String synopsis = "";
				String author = "";
				
				if(i%2==0) {
					 title = "Narnia Epics" ;
					 category = "Comedy";
					 synopsis = "This book is the story that reveals human struggle for happiness.";
					 author = "K A Thakur";					
				} else {
					 title = "The Willows" ;
					 category = "Fiction";
					 synopsis = "Sci-Fi Adventure of the era.";
					 author = "Williams Jones";
				}
				if(i%3==0) {
					 title = "The Archer" ;
					 category = "Adventure";
					 synopsis = "The jungle trains a man whose skills we should be equiped with.";
					 author = "J A Poppins";					
				}
				if(i%5==0) {
					 title = "Jack & Jill" ;
					 category = "Children";
					 synopsis = "Story of kids.";
					 author = "Jackson Kim";					
				}if(i%6==0) {
					 title = "Romeo today" ;
					 category = "Romance";
					 synopsis = "Love Story.";
					 author = "Tom Care";					
				}
				
				bookRepository.save(new Book(isin, title, category, synopsis, author, rate, imageName));
			}
			
			for (int i = 100; i <= 999; i++) {

				String imageName = "0000000" + i + ".jpg";
				
				String isin = i + 2 + "101" + i * 2;
				Float rate = (float) (i * 525.50);

				String title = "" ;
				String category = "";
				String synopsis = "";
				String author = "";
				
				if(i%2==0) {
					 title = "Narnia Epics" ;
					 category = "Comedy";
					 synopsis = "This book is the story that reveals human struggle for happiness.";
					 author = "K A Thakur";					
				} else {
					 title = "The Willows" ;
					 category = "Fiction";
					 synopsis = "Sci-Fi Adventure of the era.";
					 author = "Williams Jones";
				}
				if(i%3==0) {
					 title = "The Archer" ;
					 category = "Adventure";
					 synopsis = "The jungle trains a man whose skills we should be equiped with.";
					 author = "J A Poppins";					
				}
				if(i%5==0) {
					 title = "Jack & Jill" ;
					 category = "Children";
					 synopsis = "Story of kids.";
					 author = "Jackson Kim";					
				}if(i%6==0) {
					 title = "Romeo today" ;
					 category = "Romance";
					 synopsis = "Love Story.";
					 author = "Tom Care";					
				}
				
				bookRepository.save(new Book(isin, title, category, synopsis, author, rate, imageName));
			}
			
			for (int i = 1000; i <= 9999; i++) {

				String imageName = "000000" + i + ".jpg";
				
				String isin = i + 2 + "101" + i * 2;
				Float rate = (float) (i * 525.50);

				String title = "" ;
				String category = "";
				String synopsis = "";
				String author = "";
				
				if(i%2==0) {
					 title = "Narnia Epics" ;
					 category = "Comedy";
					 synopsis = "This book is the story that reveals human struggle for happiness.";
					 author = "K A Thakur";					
				} else {
					 title = "The Willows" ;
					 category = "Fiction";
					 synopsis = "Sci-Fi Adventure of the era.";
					 author = "Williams Jones";
				}
				if(i%3==0) {
					 title = "The Archer" ;
					 category = "Adventure";
					 synopsis = "The jungle trains a man whose skills we should be equiped with.";
					 author = "J A Poppins";					
				}
				if(i%5==0) {
					 title = "Jack & Jill" ;
					 category = "Children";
					 synopsis = "Story of kids.";
					 author = "Jackson Kim";					
				}if(i%6==0) {
					 title = "Romeo today" ;
					 category = "Romance";
					 synopsis = "Love Story.";
					 author = "Tom Care";					
				}
				
				bookRepository.save(new Book(isin, title, category, synopsis, author, rate, imageName));
			}
		};
	}*/

}