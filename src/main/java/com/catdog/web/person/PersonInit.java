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
		long count = personRepository.count();
		if(count == 0 ) {
			Person person = null;
			String[][] mtx = {{"hong","1","홍길동","1980-01-01","M","1","1","300"},
					{"kim","1","김유신","1980-05-05","M","2","2","250" },
					{"park","1","박지성","1981-06-05","M","3","3","200"},
					{"01","1","유관순","1985-09-09","M","1","4","300"},
					{"02","1","나자바","2000-01-01","M","2","1","155"},
					{"03","1","김지미","1993-03-09","F","3","2","170"},
					{"04","1","김자바","1995-05-09","M","1","3","200"},
					{"05","1","이지미","1996-06-09","F","2","4","50"},
					{"06","1","남자바","1999-07-09","M","3","1","160"},
					{"07","1","안지미","1997-09-09","F","1","2","180"},
					{"08","1","이지미","1992-02-09","F","2","3","190"},
					{"09","1","황지미","1991-04-09","F","3","4","130"},
					{"10","1","강지미","1985-06-09","F","1","1","110"},
					{"11","1","이자바","1987-07-09","M","2","2","160"},
					{"12","1","신자바","1988-09-09","M","3","3","200"},
					{"13","1","신지미","1989-01-09","F","1","4","135"},
					{"14","1","나자바","1991-11-09","M","2","1","120"},
					{"15","1","나지미","1993-12-09","F","3","2","220"},
					{"16","1","성자바","1995-02-09","M","2","3","300"},
					{"mo","1", "모모",  "1994-06-05", "F", "3" ,"4","87" },
	                {"sa","1", "사나",  "1992-06-05", "F", "2" ,"1","42" },
	                {"ji","1", "지효",  "1992-06-05", "F", "1" ,"2","98" },
	                {"da","1", "다현",  "1994-06-05", "F", "3" ,"4","75" },
	                {"jj","1", "쯔위",  "1996-06-05", "F", "2" ,"3","67" },
	                {"cy","1", "채영",  "1999-06-05", "F", "1" ,"2","45" },
	                {"na","1", "나연",  "1995-06-05", "F", "2" ,"1","82" },
	                {"jung","1", "정연",  "1995-06-05", "F", "3" ,"3","68" },
	                {"mi","1", "미나",  "1992-06-05", "F", "2" ,"2","47" },
	                {"im","1", "임꺽정",  "1992-06-05", "M", "1" ,"4","52" },
	                {"iu","1", "아이유",  "1994-06-05", "F", "2" ,"4","96" },
	                {"you","1", "유재석",  "1998-06-05", "M", "3" ,"1","37" },
	                {"kim","1", "김수로",  "1990-06-05", "M", "2" ,"3","83" },
	                {"jo","1", "조세호",  "1991-06-05", "M", "2" ,"2","72" },
					{"17","1","성지미","1985-09-09","F","3","4","270"}};
			
			for(String[] arr: mtx) {
				person = new Person();
				person.setUserid(arr[0]);
				person.setPasswd(arr[1]);
				person.setName(arr[2]);
				person.setBirthday(df.parse(arr[3]));
				person.setGender(arr[4]);
				person.setHak(Integer.parseInt(arr[5]));
				person.setBan(Integer.parseInt(arr[6]));
				person.setScore(Integer.parseInt(arr[7]));
				personRepository.save(person);
   			}
//			for(int i=0;i<mtx.length;i++) {
//				person = new Person();
//				person.setUserId(mtx[i][0]);
//				person.setPass(mtx[i][1]);
//				person.setName(mtx[i][2]);
//				person.setBirthday(df.parse(mtx[i][3]));
//				personRepository.save(person);
//			}
		}
	}
}
