package com.emervel.service;

import com.emervel.domain.Author;
import com.emervel.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guopm on 03/06/2017.
 */
@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
    }
    public Author getAuthorByFirstName(String slug) {
        return authorRepository.getAuthorByFirstName(slug);
    }
}
