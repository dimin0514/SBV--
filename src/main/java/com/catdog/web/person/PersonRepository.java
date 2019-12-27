package com.catdog.web.person;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	public Person findByUseridAndPasswd(String userid, String passwd);
	public Person findByUserid(String userid);
//	@Modifying
//	@Query(value="UPDATE PERSON SET score =:#{#param.score} , ban = :#{#param.ban}, hak =:#{#param.hak}   WHERE id = :#{#param.id}", nativeQuery=false)
//	public Person update(Person param);
	
//	@Query(value="SELECT * FROM PERSON WHERE ROLE=\"STUDENT\" AND SCORE IN (SELECT MAX(SCORE)  FROM PERSON GROUP BY HAK)", nativeQuery = true)
//	public List<Person> findGroupByHak();
	
	@Query(value="SELECT * FROM PERSON GROUP BY HAK", nativeQuery=true)
	public List<Person> findGroupByHak();
	public List<Person> findByRole(String role);
	
	
}
