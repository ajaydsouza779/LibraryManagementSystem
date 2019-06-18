package com.pgdca.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pgdca.lms.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> { //JpaRepository

	 //@Query ("SELECT b FROM Book b WHERE b.category = :category")
	List<Book> findByCategory(String category);

	@Query (nativeQuery = true,value="SELECT * FROM Book where id < 150 OR id > 499 order by id desc limit 5")
		List<Book> findLatest();

}