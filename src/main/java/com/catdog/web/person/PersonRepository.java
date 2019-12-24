package com.catdog.web.person;

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
	
}
