package com.example.abc;

import org.springframework.stereotype.Service;

/**
 * Created by guopm on 13/05/2017.
 */
//Ponemos Service para que Spring sepa como debe tratar esta clase y le pasamos un nombre si no queremos que coja por defecto el nombre de la clase
@Service("NotificationService")
public class NotificationService {
    public NotificationService(){

    }
    public void send(){

    }
    public void sendSync(){

    }
    @Override
    public String toString(){
        return "NotificationService()";
    }
}
