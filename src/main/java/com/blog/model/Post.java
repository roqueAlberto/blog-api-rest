package com.blog.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.blog.validation.ImageUrl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
@SQLDelete(sql = "UPDATE post SET deleted = true WHERE id=?")
@FilterDef(name = "postDeleted", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter( name = "postDeleted",condition = "deleted = :isDeleted")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "CONTENT")
	private String content;
	
	@ImageUrl
	@Column(name = "IMAGE")
	private String image;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "CREATION_DATE")
	private LocalDate creationDate;
	
	@JsonIgnoreProperties("posts")
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;
	
	@JsonIgnoreProperties("posts")
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORY")
	private Category category;
	
	private boolean deleted = Boolean.FALSE;

}
