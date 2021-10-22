package com.blog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Post;
import com.blog.service.PostService;

@RestController
@RequestMapping(path = "/api/blog")
public class BlogController {

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public List<com.blog.dto.Post> listBlogs(@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "category", required = false) String category,
			@RequestParam(value = "isDeleted", required = false, defaultValue = "false")boolean isDeleted) {

		List<com.blog.dto.Post> postsRequest = new ArrayList<>();
		com.blog.dto.Post post;

		List<Post> posts;

		if (title != null && category == null) {
			posts = postService.listAllByTitle(title);
		} else if (category != null && title == null) {
			posts = postService.listAllByCategory(category);
		} else if (title != null && category != null) {
			posts = postService.listAllByTitleAndCategory(title, category);
		}else {
			posts = postService.listAll();
		}

		for (int i = 0; i < posts.size(); i++) {
			post = new com.blog.dto.Post(posts.get(i));
			postsRequest.add(post);
		}

		return postsRequest;
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") int id) {

		Post post = postService.findById(id);

		if (post != null) {
			return ResponseEntity.ok(post);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/posts")
	public ResponseEntity<Post> save(@RequestBody Post post) {         
		Post postResponse = postService.save(post);
        return ResponseEntity.ok(postResponse);
	}
	
	@PatchMapping("/posts/{id}")
	public ResponseEntity<Post> update(@PathVariable("id") int id){
		
		Post post = postService.findById(id);
		
		if(post != null) {
			Post postResponse = postService.save(post);
			return ResponseEntity.ok(postResponse);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> delete(@PathVariable("id") int id){
		
		Post post = postService.findById(id);
		
		if(post != null) {
			postService.delete(post.getId());
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
