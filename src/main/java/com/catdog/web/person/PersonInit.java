package com.catdog.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.catdog.web.person.Person;
import com.catdog.web.person.PersonRepository;

@Component
public class PersonInit implements ApplicationRunner{
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public PersonInit(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		long count = personRepository.count();
//		if(count == 0 ) {
//			Person person = null;
//			String[][] mtx = {{"hong","1","홍길동","1980-01-01","true","0","0","0","teacher"},
//					{"kim","1","김유신","1980-05-05","true","0","0","0","manager" },
//					{"park","1","박지성","1981-06-05","true","3","3","200","student"},
//					{"01","1","유관순","1985-09-09","true","1","4","300","student"},
//					{"02","1","나자바","2000-01-01","true","2","1","155","student"},
//					{"03","1","김지미","1993-03-09","false","3","2","170","student"},
//					{"04","1","김자바","1995-05-09","true","1","3","200","student"},
//					{"05","1","이지미","1996-06-09","false","2","4","50","student"},
//					{"06","1","남자바","1999-07-09","true","3","1","160","student"},
//					{"07","1","안지미","1997-09-09","false","1","2","180","student"},
//					{"08","1","이지미","1992-02-09","false","2","3","190","student"},
//					{"09","1","황지미","1991-04-09","false","3","4","130","student"},
//					{"10","1","강지미","1985-06-09","false","1","1","110","student"},
//					{"11","1","이자바","1987-07-09","true","2","2","160","student"},
//					{"12","1","신자바","1988-09-09","true","3","3","200","student"},
//					{"13","1","신지미","1989-01-09","false","1","4","135","student"},
//					{"14","1","나자바","1991-11-09","true","2","1","120","student"},
//					{"15","1","나지미","1993-12-09","false","3","2","220","student"},
//					{"16","1","성자바","1995-02-09","true","2","3","300","student"},
//					{"mo","1", "모모",  "1994-06-05", "false", "3" ,"4","87","student"},
//	                {"sa","1", "사나",  "1992-06-05", "false", "2" ,"1","42","student"},
//	                {"ji","1", "지효",  "1992-06-05", "false", "1" ,"2","98","student"},
//	                {"da","1", "다현",  "1994-06-05", "false", "3" ,"4","75","student"},
//	                {"jj","1", "쯔위",  "1996-06-05", "false", "2" ,"3","67","student"},
//	                {"cy","1", "채영",  "1999-06-05", "false", "1" ,"2","45","student"},
//	                {"na","1", "나연",  "1995-06-05", "false", "2" ,"1","82","student"},
//	                {"jung","1", "정연",  "1995-06-05", "false", "3" ,"3","68","student"},
//	                {"mi","1", "미나",  "1992-06-05", "false", "2" ,"2","47","student"},
//	                {"im","1", "임꺽정",  "1992-06-05", "true", "1" ,"4","52","student"},
//	                {"iu","1", "아이유",  "1994-06-05", "false", "2" ,"4","96","student"},
//	                {"you","1", "유재석",  "1998-06-05", "true", "3" ,"1","37","student"},
//	                {"ss","1", "김수로",  "1990-06-05", "true", "2" ,"3","83","student"},
//	                {"jo","1", "조세호",  "1991-06-05", "true", "2" ,"2","72","student"},
//					{"17","1","성지미","1985-09-09","false","3","4","270","student"}};
//			
//			for(String[] arr: mtx) {
//				person = new Person();
//				person.setUserid(arr[0]);
//				person.setPasswd(arr[1]);
//				person.setName(arr[2]);
//				person.setBirthday(df.parse(arr[3]));
//				person.setMale(Boolean.parseBoolean(arr[4]) );
//				person.setHak(Integer.parseInt(arr[5]));
//				person.setBan(Integer.parseInt(arr[6]));
//				person.setScore(Integer.parseInt(arr[7]));
//				person.setRole((arr[8]));
//				personRepository.save(person);
//   			}
////			for(int i=0;i<mtx.length;i++) {
////				person = new Person();
////				person.setUserId(mtx[i][0]);
////				person.setPass(mtx[i][1]);
////				person.setName(mtx[i][2]);
////				person.setBirthday(df.parse(mtx[i][3]));
////				personRepository.save(person);
////			}
//		}
//	}
}
