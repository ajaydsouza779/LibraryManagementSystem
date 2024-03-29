package com.pgdca.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgdca.lms.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
  
}
