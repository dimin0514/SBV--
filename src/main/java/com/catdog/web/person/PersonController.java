package com.catdog.web.person;

import java.util.ArrayList;
import java.util.Comparator;
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
			map.put("result","True");
			map.put("person",person);
		}else {
			map.put("result","False");
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
	public List<Person> list(){
		printer.accept("list");
		Iterable<Person> entites = personRepository.findAll();
		//Iterable<Person> entites = personRepository.findByRole("student");
		List<Person> list = new ArrayList<>();
		for(Person p: entites) {
			Person dto = modelMapper.map(p, Person.class);
			list.add(dto);
		}
		list.stream()
		.filter(role-> role.getRole().equals("student"));
		return list.stream()
				.sorted(Comparator.comparing(Person::getPersonid)
						.reversed()).collect(Collectors.toList());
	}
//	@GetMapping("/students/search/{searchWord}")
//	public List<Person> findSome2(@PathVariable String searchWord){
//		List<Person> list = new ArrayList<>();
//		switch (searchWord) {
//		case "topByGrade":
//			Iterable<Person> entites = personRepository.findGroupByHak();
//			for(Person p: entites) {
//				Person dto = modelMapper.map(p, Person.class);
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
	public Stream<Person> findSome(@PathVariable String searchWord){
		printer.accept("넘어온 검색어: "+searchWord);
		List<Person> personDTOs = new ArrayList<>();
		List<Person> persons = new ArrayList<>();;
		String switchKey = "";
		switch(searchWord) {
			case "namesOfStudents" :break;
			case "streamToArray" :break;
			case "streamToMap" :break;
			case "theNumberOfStudents" :break;
			case "totalScore" :break;
			case "topStudent" :break;
			case "getStat" :break;
			case "nameList" :break;
			case "남학생목록":  case "여학생목록":
				switchKey = (searchWord=="남") ? "partioningByMale" : "partioningByFemale";
				break;
			case "partioningCountPerGender" :break;
			case "partioningTopPerGender" :break;
			case "partioningRejectPerGender" :break;
			case "groupingByBan" :break;
			case "groupingByGrade" :break;
			case "groupingByCountByLevel" :break;
			case "3학년목록" :
				switchKey = "groupingByHak";
				break;
			case "groupingByHakAndBan" :break;
			case "groupingTopByHakAndBan" :break;
			case "groupingByStat" :break;
		}
		switch(switchKey) {
			case "namesOfStudents" :break;
			case "streamToArray" :break;
			case "streamToMap" :break;
			case "theNumberOfStudents" :break;
			case "totalScore" :break;
			case "topStudent" :break;
			case "getStat" :break;
			case "nameList" :break;
			case "partioningByMale" :
				persons = personService.partioningByGender(true);
				break;
			case "partioningCountPerGender" :break;
			case "partioningTopPerGender" :break;
			case "partioningRejectPerGender" :break;
			case "groupingByBan" :break;
			case "groupingByGrade" :break;
			case "groupingByCountByLevel" :break;
			case "groupingByHakAndBan" :break;
			case "groupingTopByHakAndBan" :break;
			case "groupingByStat" :break;
			case "groupingByHak" :
				Iterable<Person> entites = personRepository.findGroupByHak();
				personDTOs = new ArrayList<>();
				for(Person p: entites) {
					Person dto = modelMapper.map(p, Person.class);
					personDTOs.add(dto);
				}
				
				
		}
		return personDTOs.stream()
				.filter(role-> role.getRole().equals("student"));
		
	}
}
