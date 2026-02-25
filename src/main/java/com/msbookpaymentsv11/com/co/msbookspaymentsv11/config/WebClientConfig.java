//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.config;

//IMPORTACIÓN DE LIBRERIAS:
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de la configuración del WebClient para conectar con otros microservicios.
*/
@Configuration//DECLARACIÓN DE COMPONENT PARA INYECTAR LA CONFIGURACIÓN.
public class WebClientConfig {
  
  @Bean//DEVUELVE UN OBJETO QUE DEBE SER REGISTRADO EN EL CONTENEDOR DE SPRING.
  @LoadBalanced//CARGAMOS EL BALANCEADOR DE CARGA DE SPRING.
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }
}
