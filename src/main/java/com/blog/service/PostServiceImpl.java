package com.blog.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Post;
import com.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
    private EntityManager entityManager;
	@Override
	public List<Post> listAll() {
		
		List<Post> posts = null;
		try {		
		 posts = postRepository.listAll();
		}catch (Exception e) {
			
		System.out.println(e.getMessage());
			
		}
		return posts;
	}

	@Override
	public List<Post> listAllByTitle(String title) {	
		return postRepository.listAllByTitle(title);	
	}
	
	@Override
	public List<Post> listAllByCategory(String category) {	
		return postRepository.listAllByCategory(category);
	}

	@Override
	public List<Post> listAllByTitleAndCategory(String title, String category) {
		return postRepository.listAllByTitleAndCategory(title, category);
	}

	@Override
	public Post findById(int id) {
		Optional<Post> post = postRepository.findById(id);	
		return post.get();
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}


	@Override
	public void delete(int id) {	
	   postRepository.deleteById(id);
	}

	@Override
	public List<Post> listAll(boolean isDeleted) {
		Session session = entityManager.unwrap(Session.class);
	    Filter filter =  (Filter) session.enableFilter("deletedCarFilter");
	    filter.setParameter("isDeleted", isDeleted);
	    List<Post> posts = postRepository.findAll();
	    session.disableFilter("deletedCarFilter");
	  
		return posts;
	}

}
