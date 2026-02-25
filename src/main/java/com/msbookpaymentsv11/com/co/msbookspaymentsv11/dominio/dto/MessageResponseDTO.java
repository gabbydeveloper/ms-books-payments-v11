//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del DTO de respuesta genérica para los mensajes del sistema,
* incluyendo estado HTTP, mensaje descriptivo e ID del registro creado.
*/
@JsonInclude(JsonInclude.Include.NON_NULL)//EXCLUYE CAMPOS NULOS DE LA RESPUESTA JSON.
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
@Builder//PERMITE CONSTRUIR EL OBJETO CON EL PATRÓN BUILDER.
@AllArgsConstructor//GENERA UN CONSTRUCTOR CON TODOS LOS ARGUMENTOS.
public class MessageResponseDTO {
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DEL DTO:
  private HttpStatus status;
  private String message;
  private Long idCreated;
}
