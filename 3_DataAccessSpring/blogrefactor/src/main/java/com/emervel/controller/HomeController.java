package com.emervel.controller;

import com.emervel.service.AuthorService;
import com.emervel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guopm on 27/05/2017.
 */
@Controller
public class HomeController {

    private PostService postService;
    private AuthorService authorService;

    @Autowired
    public HomeController(PostService postService, AuthorService authorService) {
        this.postService=postService;
        this.authorService=authorService;
    }

    /**
     * @param model The model presents a placeholder to hold the information you want to display on the view.
     *              It could be a string, which is in your above example, or it could be an object containing bunch of properties.
     *              It is a convenience constructor that populates the model with one attribute / value pair.
     * @return
     */
    @RequestMapping("/")
    public String home(Model model) {
        /*
        * Ejemplo perfecto de modelo-vista-controlador
        * 1.Se hace una solicitud que encaja con "/" para que sea tratada por nuestro controlador
        * 2.El controlar la recoge e invoca a un servicio donde tiene la logica que permite obtener el ultimo Post
        * 3.El servicio invoca a la interfaz PostRepository que gestiona la entidad Post que esta linkada por JPA a la tabla POST
        * 4.La intefaz devuelve la entidad obtenida al servicio que la devuelve al controladr
        * 5.El controlador inserta la entidad en el Modelo y direcciona la vista donde se mostraran los resultados
        * 6.En la vista se puede acceder a todos los atributos insertados en el modelo, es decir al objeto Post y todos sus atributos
        * */
        model.addAttribute("post",postService.getTheLastPost());
        return "index";
    }

    @RequestMapping("posts/list")
    public String listPost(Model model) {
        model.addAttribute("posts",postService.list());
        return "post/list";
    }

    @RequestMapping("posts/view/{slug}")
    public String view(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("post",postService.getBySlug(slug));
        return "post/view";
    }

    @RequestMapping("author/{slug}")
    public String viewAuthor(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("post",authorService.getAuthorByFirstName(slug));
        return "post/view";
    }

    @RequestMapping("keyword/{keyword}")
    public String viewByKeyword(@PathVariable(value="keyword") String keyword, Model model) {
        model.addAttribute("posts",postService.listByKeyword(keyword));
        return "post/list";
    }
}
