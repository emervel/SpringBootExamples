package com.emervel.h2demo.service;

import com.emervel.h2demo.domain.Author;
import com.emervel.h2demo.domain.Post;
import com.emervel.h2demo.repository.AuthorRepository;
import com.emervel.h2demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by guopm on 27/05/2017.
 */
@Service
public class DataLoader {
    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DataLoader(PostRepository postRepository,AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
        this.postRepository=postRepository;
    }

    @PostConstruct
    private void loadData() {
        Author author = new Author("Natalia","Merino");
        authorRepository.save(author);
        Post post = new Post("No sabe Spring");
        post.setBody("Lo tiene que aprender");
        post.setPostedOn(new Date());
        post.setAuthor(author);
        postRepository.save(post);
    }
}
