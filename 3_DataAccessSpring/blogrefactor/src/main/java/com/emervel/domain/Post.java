package com.emervel.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 0007195 on 25/05/2017.
 * Con table le hemos dicho en que tabla se va a insertar
 * Por defecto h2 crea estas tablas cuando arranca y desaparecen cuando se cierra la aplicacion
 */
@Entity
@Table(name = "POST")
public class Post {

    @Id    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TEXT")
    private String teaser;

    private String slug;

    /**
     * Con createddate ya no sera necesario que hagamos un set. Spring lo rellenar automaticamente cuando
     * se cree la instancia
     */
    @CreatedDate    @Column(columnDefinition = "TIMESTAMP")
    private Date postedOn;

    @ElementCollection
    private List<String> keywords;

    private Boolean active;

    /**
     * Un post tiene un author pero un autor puede tener varios posts
     */
    @ManyToOne
    private Author author;


    /**
     * Se necesita para JPA y con esta etiqueta evitamos el warning
     */
    @SuppressWarnings("unused")
    private Post() {

    }

    public Post(String title) {
        this.setTitle(title);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", postedOn=" + postedOn +
                '}';
    }
}
