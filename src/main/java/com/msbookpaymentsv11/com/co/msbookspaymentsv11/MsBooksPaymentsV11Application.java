//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11;

//IMPORTACIÓN DE LIBRERIAS:
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//DECLARACIÓN DE LA CLASE PRINCIPAL:
@SpringBootApplication
public class MsBooksPaymentsV11Application {
        
	/**
	* Método principal que inicia la aplicación Spring Boot del microservicio de pagos.
	*/
	public static void main(String[] args) {
		SpringApplication.run(MsBooksPaymentsV11Application.class, args);
	}
}
