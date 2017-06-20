package com.example.demo;

import com.example.abc.NotificationService;
import com.example.abc.Persona;
import com.example.abc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guopm on 13/05/2017.
 */
@RestController
public class PageController {

    private NotificationService notificationService;

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /*
    * Puedes inyectar dependencias de otros objetos en vez de crearlas usando el autowired para que Spring las cree, las maneje
    * y las inyecte por ti. El autowired lo debes usar en la clase donde van a ser usados los objetos y lo puedes usar de dos formas
    * distintas:
    * -> en los seter para establecer los objetos individualmente
    * -> en los constructores para poner varios a la vez y olvidarte
    * Fijate que con el autowired nos hemos quitado los news por lo que en la clase donde "instancio" no tengo que saber nada
    * de como se construye la clase que voy a usar
    * */
    @RequestMapping("/inyectar")
    public String home() {
        return notificationService.toString();
    }

    /*
    * Para acceder a las propiedades basta con hacer esto
    * */
    @Value("${pageController.msg}")
    private String pageControllerMsg;

    @RequestMapping("/properties")
    public String homeProperties() {
        return pageControllerMsg;
    }

    /*
    * Una combinacion de las otras dos, inyecto un user y a ese user le seteo todas sus variables usando properties
    * */
    private Persona persona;

    @Autowired
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @RequestMapping("/allproperties")
    public String homeAllProperties() {
        return persona.toString();
    }
}
