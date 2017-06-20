package com.emervel.service;

import com.emervel.domain.Author;
import com.emervel.domain.Post;
import com.emervel.repository.AuthorRepository;
import com.emervel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by guopm on 27/05/2017.
 */
@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository=postRepository;
    }

    public Post getTheLastPost() {
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<Post> list() {
        //postRepository.findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc("Eduardo");
        return postRepository.findAllByOrderByPostedOnDesc();
    }

    public Post getBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

    public List<Post> listByKeyword(String keyword) {
        return postRepository.findAllByKeywords(keyword);
    }
}
