package com.pgdca.lms.error;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.pgdca.lms.model.Note;
import com.pgdca.lms.repository.NoteRepository;
@Controller
public class NoteController {

	@Autowired
	NoteRepository noteRepo;
	
	@RequestMapping(value = "/welcomeNote", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	
    	System.out.println("---------------------------------7777777777777777--------------");
    	
    	Note note = new Note();
    	note.setTitle("123");
    	note.setContent("test123");
    	
    	System.out.println("----------------------------------8888888888888888888888888--------------");
    	
    	noteRepo.save(note);
    	
    	List<Note> list_of_Notes=  noteRepo.findAll();
    	
    	model.addObject("listOfBooks", list_of_Notes);
    	
    	model.setViewName("Welcome");
    	return model;
    }
}
