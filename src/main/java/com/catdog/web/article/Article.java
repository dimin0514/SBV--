package com.catdog.web.article;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.catdog.web.person.Person;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter(value = AccessLevel.PROTECTED)
@ToString
@Table(name="ARTICLE") //아이디당 한개 글쓰는거 아니니깐  유니크 제한조건 필요없음
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ARTICLEID")@NotNull 
	private Long articleid;
	@Column(name="USERID") @NotNull
	private String userid;
	@Column(name="COMMENTS") //여기는 처음에 널값.. 코멘트가 처음부터달리지는 않음
	private String comments;
	@Column(name="TITLE") @NotNull
	private String title;
	@Column(name="CONTENTS") @NotNull
	private String content;
	@Column(name="IMG") 
	private String img;
	@Column(name="BOARDTYPE") @NotNull
	private String boardtype;
	@Column(name="RATING") 
	private String rating;
	@Temporal(TemporalType.DATE)
	@Column(name="REGDATE") @NotNull
	private Date regdate;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personid")
    private Person personid;
	
	@Builder
	private Article( Long id,  String userid, String comments,  String title,
			 String content, String img,  String boardtype, String rating,  Date regdate) {
//		super();
//		this.id = id; // 아이디는 직접 생성되니깐 삭제
		this.userid = userid;
		this.comments = comments;
		this.title = title;
		this.content = content;
		this.img = img;
		this.boardtype = boardtype;
		this.rating = rating;
		this.regdate = regdate;
	}
	
	
}