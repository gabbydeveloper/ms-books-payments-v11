//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.exception;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.MensajeRespuesta;
import lombok.Getter;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de la excepción de negocio personalizada para el microservicio de pagos.
* Encapsula un MensajeRespuesta con el código HTTP y el mensaje de error correspondiente.
*/
@Getter//GENERA AUTOMÁTICAMENTE LOS MÉTODOS GETTER PARA LOS ATRIBUTOS DE LA CLASE.
public class BusinessException extends RuntimeException {
  
  //DECLARACIÓN DEL MENSAJE DE RESPUESTA ASOCIADO A LA EXCEPCIÓN:
  private final MensajeRespuesta MensajeRespuesta;
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param MensajeRespuesta Enum con el mensaje y el código HTTP del error de negocio.
  * Constructor que recibe el mensaje de respuesta y lo asigna a la excepción.
  */
  public BusinessException(MensajeRespuesta MensajeRespuesta) {
    super(MensajeRespuesta.getMensaje());
    this.MensajeRespuesta = MensajeRespuesta;
  }
}
