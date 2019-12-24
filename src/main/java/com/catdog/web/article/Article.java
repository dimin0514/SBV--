package com.catdog.web.article;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
@Table(name="ARTICLE")
public class Article {
	@Id
	@GeneratedValue
	@Column(name="articleseq", nullable=false) private String articleseq;
	@Column(name="uid", length = 64, nullable=false) private String uid;
	@Column(name="title", length = 64, nullable=false) private String title;
	@Column(name="content", length = 64, nullable=false) private String content;
	@Column(name="comments", length = 128, nullable=false) private String comments;
	@Column(name="msg", length = 64, nullable=false) private String msg;
	@Column(name="rating", length = 64, nullable=false) private String rating;
	@Column(name="boardType", length = 64, nullable=false) private String boardType;
	@Temporal(TemporalType.DATE)
	@Column(name="regdate", nullable=false) private Date regdate;
	

}
