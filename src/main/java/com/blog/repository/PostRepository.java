package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query(value = "FROM Post p ORDER BY p.creationDate DESC")
	public List<Post> listAll();
	
	@Query(value = "FROM Post p WHERE p.title LIKE %:title% ORDER BY p.creationDate DESC")
	public List<Post> listAllByTitle(@Param("title") String title);
	
	@Query(value = "FROM Post p WHERE p.category.name LIKE %:category% ORDER BY p.creationDate DESC")
	public List<Post> listAllByCategory(@Param("category") String category);
	
	@Query(value = "FROM Post p WHERE p.title LIKE %:title% AND p.category.name LIKE %:category% ORDER BY p.creationDate DESC")
	public List<Post> listAllByTitleAndCategory(@Param("title") String title, @Param("category") String category);
}
