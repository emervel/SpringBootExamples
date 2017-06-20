package com.example.bbdd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by guopm on 14/05/2017.
 * Esta clase de tipo configuracion devuelve un bean llamado dataSource que es una instancia de una clase
 * DataSource. Dependiendo del entorno configurado en el properties devolvera un bean u otro. Para gestionar los
 * profiles podemos usar:
 * 1. Clases de Configuracion como estas que tienen un mismo nombre de bean para cada profile \
 * 2. Establecer varios propeties con el sufijo profile, para que devuelva la variable que corresponda como hemos
 * en este ejemplo con el puerto
 * a las mismas variables pero nombrando un valor
 */
@Configuration
public class DataSourceConfig {

    @Value("${puerto}")
    private String puerto;

    @Bean("dataSource")
    @Profile("development")
    DataSource development(){
        return new DataSource("desarrollo", puerto);
    }

    @Bean("dataSource")
    @Profile("production")
    DataSource production(){
        return new DataSource("produccion", puerto);
    }
}
