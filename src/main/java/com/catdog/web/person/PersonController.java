package com.catdog.web.person;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.web.utl.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+" "));
		return sb.toString();
	}
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person param) {
		HashMap<String, Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", param.getUserid()));
		printer.accept(String.format("PASSWD: %s", param.getPasswd()));
		person = personRepository.findByUseridAndPasswd(param.getUserid(),param.getPasswd());
		
		if(person != null) {
			printer.accept("로그인 성공");
			map.put("result","SUCCESS");
			map.put("person",person);
		}else {
			map.put("result","FAIL");
			map.put("person",person);
		}
		
		return map;
		
	}
	@PostMapping("/join")
	public HashMap<String,String> join(@RequestBody Person param) {
		HashMap<String,String> map = new HashMap<>();
		printer.accept("회원가입 진입");
		personRepository.save(param);
		map.put("result","SUCCESS");
		return map;
	}
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid) {
		printer.accept("회원탈퇴 진입");
		personRepository.delete(personRepository.findByUserid(userid));
	}
	
//	@PostMapping("/update/{userid}")
//	public void modefy(@PathVariable String userid,@RequestBody Person param) {
//		personRepository.update(param);
//	}

}
