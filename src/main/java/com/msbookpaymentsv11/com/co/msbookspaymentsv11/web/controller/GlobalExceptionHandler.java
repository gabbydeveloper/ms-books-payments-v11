//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.exception.BusinessException;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.MensajeRespuesta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del manejador global de excepciones para el microservicio de pagos.
* Intercepta las excepciones de negocio y retorna respuestas HTTP estructuradas.
*/
@RestControllerAdvice//INTERCEPTA LAS EXCEPCIONES LANZADAS EN TODOS LOS CONTROLADORES.
public class GlobalExceptionHandler {
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param ex Excepción de negocio capturada con el mensaje y código HTTP.
  * @return ResponseEntity con el DTO de respuesta y el código de estado HTTP correspondiente.
  * Maneja las excepciones de tipo BusinessException y retorna la respuesta apropiada.
  */
  //MANEJADOR DE EXCEPCIONES DE NEGOCIO:
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<MessageResponseDTO> handleBusiness(BusinessException ex) {
    
    MensajeRespuesta msg = ex.getMensajeRespuesta();
    
    MessageResponseDTO error = new MessageResponseDTO(
        msg.getStatus(),
        msg.getMensaje(),
        null
    );
    
    return new ResponseEntity<>(error, msg.getStatus());
  }
}
