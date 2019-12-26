package com.catdog.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Lazy
public class PersonDTO {
	private Long id;
	private String userid;
	private String passwd;
	private String name;
	private Date birthday;
	private String gender;
	private int hak;
	private int ban;
	private int score;
	private String role;

}
