package com.blog.service;

import java.util.List;

import com.blog.model.Post;

public interface PostService {

	List<Post> listAll();
	List<Post> listAllByTitle(String title);
	List<Post> listAllByCategory(String category);
	List<Post> listAllByTitleAndCategory(String title, String category);
	List<Post> listAll(boolean isDeleted);
	Post findById(int id);
	Post save(Post post);
	void delete(int id);
}
