package com.emervel.repository;

import com.emervel.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by guopm on 27/05/2017.
 * Post indica la entidad y Long indica la clave que usaremos para buscar en la tabla
 * donde se guardan las entidades. Al extender de CrudRepository ya tienes todos los metodos para insertar, buscar, borrar
 * o modificar, pero lo ponemos asi por si quieres anadir mas
 */
public interface PostRepository extends CrudRepository<Post,Long> {

    //Find by posts===========================================================================================
    /**
     * El metodo es solo findFirstByOrderBy pero JPA nos permite anadir directamente el atributo de la clase
     * por el que queremos ordenar y la direccion de esa ordencion. Sin picar nada!! Out of the box!!
     * Ahora entiendo porque necesito una interfaz que herede de crudrepository en lugar de usarla directamente
     * porque nosotros seremos quienes pondremos estos metodos
     * @return
     */
    Post findFirstByOrderByPostedOnDesc();

    List<Post> findAllByOrderByPostedOnDesc();

    Post findBySlug(String slug);

    //Find by author===========================================================================================
    List<Post> findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(String first);

    //Find by keywords===========================================================================================
    List<Post> findAllByKeywords(String keyword);

    //Custom Queries===========================================================================================
    @Query("select p from post p where p.slug=?1")
    Post findPostBySlug(String slug);

    @Query("select p from post p where p.slug=:slug")
    Post findPostBySlugNameParameter(@Param("slug") String slug);

    @Query(value = "select * from post where slug=:slug", nativeQuery = true)
    Post findPosbBySlugNativeQuery(@Param("slug") String slug);
}
