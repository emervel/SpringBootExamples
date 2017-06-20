package com.example.demo;

import com.example.abc.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
@ComponentScan({"com.example.demo","com.example.abc","com.example.bbdd"})
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBeansApplication {

	@Bean
	public User user(){
		return new User("eduardo","merchan");
	}

	/**
	 * al arranque de spring le hemos anadido codigo para que acceda al conexto y recorra todos los beans,
	 * tanto los que inyectamos nosotros como los que inyecta el framework de spring por defecto
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBeansApplication.class, args);
		String[] beansName = ctx.getBeanDefinitionNames();
		Arrays.sort(beansName);
		for (String name : beansName) {
			System.out.println(name);
		}

		//Muestra el valor de un Bean que instancio en la misma clase
		System.out.println(ctx.getBean("user").toString());

		/*
		* Muestra el valor de un bean que instancio en otra clase y que inyecto para poder accederlo
		* */
		System.out.println(ctx.getBean("dataSource").toString());

	}
}
