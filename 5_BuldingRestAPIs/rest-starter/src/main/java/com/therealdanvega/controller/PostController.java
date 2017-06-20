package com.therealdanvega.controller;

import com.therealdanvega.exception.DataNotFound;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.therealdanvega.domain.Post;
import com.therealdanvega.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService postService;
	
	@Autowired
	public PostController(PostService postService){
		this.postService = postService;
	}	
	
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public Iterable<Post> list(){
		return postService.list();
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Post create(@RequestBody Post post){
		return postService.create(post);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Post read(@PathVariable(value="id") long id) throws DataNotFound {
		Post postRecuperado = postService.read(id);
		if (null == postRecuperado)
			throw new DataNotFound("El post "+id+ " no exite");
		return postRecuperado;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Post update(@PathVariable(value="id") long id, @RequestBody Post post){
		return postService.update(id,post);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") int id){
		postService.delete(id);
	}	

	@ExceptionHandler(DataNotFound.class)
	public void handleDataNotFound(DataNotFound exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.SC_NOT_FOUND, exception.getMessage());
	}
	
}
