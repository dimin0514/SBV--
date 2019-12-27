package com.catdog.web.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.web.utl.Printer;

import sun.security.acl.GroupImpl;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	@Autowired
	ModelMapper modelMapper;
	@Autowired PersonService personService;
	
	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}
	
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
	
	@PutMapping("/modify")
	public HashMap<String,Object> modify(@RequestBody Person person) {
		HashMap<String,Object> map =new HashMap<>();
		personRepository.save(person);			
		System.out.println("수정 성공");
		map.put("result", "SUCCESS");
		map.put("data", personRepository.findByUseridAndPasswd(person.getUserid(), person.getPasswd()));
		return map;
		
	}
	@GetMapping("/students")
	public Stream<PersonDTO> list(){
		printer.accept("list");
		Iterable<Person> entites = personRepository.findAll();
		//Iterable<Person> entites = personRepository.findByRole("student");
		List<PersonDTO> list = new ArrayList<>();
		for(Person p: entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			list.add(dto);
		}
		return list.stream().filter(role-> role.getRole().equals("student"));
	}
//	@GetMapping("/students/search/{searchWord}")
//	public List<PersonDTO> findSome2(@PathVariable String searchWord){
//		List<PersonDTO> list = new ArrayList<>();
//		switch (searchWord) {
//		case "topByGrade":
//			Iterable<Person> entites = personRepository.findGroupByHak();
//			for(Person p: entites) {
//				PersonDTO dto = modelMapper.map(p, PersonDTO.class);
//				list.add(dto);
//			}
//			break;
//		default:
//			break;
//		}
//		printer.accept("list");
//		return list;
//	}
	
	@GetMapping("/students/search/{searchWord}")
	public Stream<PersonDTO> findSome(@PathVariable String searchWord){
		personService.findByHak();
		switch(searchWord) {
			case "namesOfStudents" :break;
			case "streamToArray" :break;
			case "streamToMap" :break;
			case "theNumberOfStudents" :break;
			case "totalScore" :break;
			case "topStudent" :break;
			case "getStat" :break;
			case "nameList" :break;
			case "partioningByGender" :break;
			case "partioningCountPerGender" :break;
			case "partioningTopPerGender" :break;
			case "partioningRejectPerGender" :break;
			case "groupingByBan" :break;
			case "groupingByGrade" :break;
			case "groupingByCountByLevel" :break;
			case "groupingByHakAndBan" :break;
			case "groupingTopByHakAndBan" :break;
			case "groupingByStat" :break;
		}
		Iterable<Person> entites = personRepository.findGroupByHak();
		List<PersonDTO> list = new ArrayList<>();
		for(Person p: entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			list.add(dto);
		}
		
		return list.stream()
				.filter(role-> role.getRole().equals("student"));
		
	}

}
