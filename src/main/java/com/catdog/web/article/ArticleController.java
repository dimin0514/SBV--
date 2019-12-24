package com.catdog.web.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.web.person.PersonRepository;
import com.catdog.web.utl.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ArticleController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	
	

}
