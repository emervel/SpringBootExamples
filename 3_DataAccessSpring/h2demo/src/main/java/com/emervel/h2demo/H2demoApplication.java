package com.emervel.h2demo;

import com.emervel.h2demo.domain.Post;
import com.emervel.h2demo.repository.PostRepository;
import com.emervel.h2demo.service.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


/**
 * Arranca Spring
 */
@SpringBootApplication
public class H2demoApplication {

	private static final Logger logger = LoggerFactory.getLogger(H2demoApplication.class);

	@Autowired
	PostRepository postRepository;

	@Autowired
	DataLoader dataLoader;

	public static void main(String[] args) {
		SpringApplication.run(H2demoApplication.class, args);
	}

	/**
	 * Con esta anotacion le digo que despues de terminar con el constructor debe ejecutar este metodo. Asi me aseguro que se ha
	 * terminado de inyectar el repositorio para poder usarlo
	 */
	@PostConstruct
	void seePost() {
		for (Post post : postRepository.findAll()) {
			logger.info(post.toString());
		}
	}

}
