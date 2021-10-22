package com.blog.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {

	private Integer id;
	private String title;
	private String image;
	private String category;
	private LocalDate creationDate;
	
	
	public Post(com.blog.model.Post post) {
		super();
		this.id = post.getId();
		this.title = post.getTitle();
		this.image = post.getImage();
		this.category = post.getCategory().getName();
		this.creationDate = post.getCreationDate();
	}
	
	
	
	
}
