package com.demo;

import org.springframework.stereotype.Component;

@Component
public class SaludoService {

	public String sayHello(String message) {
		System.out.println("sayHello");
        return "HOLA DESDE SALUDO SERVICE" + message;
    }
	
	public String upper(String message){
		System.out.println("upper");
		return message.toLowerCase();
	}
	
	
}
