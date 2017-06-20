package com.emervel.repository;

import com.emervel.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by guopm on 27/05/2017.
 * Post indica la entidad y Long indica la clave que usaremos para buscar en la tabla
 * donde se guardan las entidades. Al extender de CrudRepository ya tienes todos los metodos para insertar, buscar, borrar
 * o modificar, pero lo ponemos asi por si quieres anadir mas
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {
    Author getAuthorByFirstName(String slug);
}
