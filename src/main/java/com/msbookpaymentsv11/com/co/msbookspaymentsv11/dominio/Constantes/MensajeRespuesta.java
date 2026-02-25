//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes;

//IMPORTACIÓN DE LIBRERIAS:
import org.springframework.http.HttpStatus;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de los mensajes de respuesta y códigos HTTP para los cruds
* (creación, lectura, edición y eliminación de un registro).
*/
public enum MensajeRespuesta {
  
  //ÉXITO.
  EXITO_REGISTRO_CREADO( "Registro creado", HttpStatus.OK),
  
  EXITO_REGISTRO_ACTUALIZADO("Registro correctamente actualizado", HttpStatus.OK),
  
  EXITO_REGISTRO_ELIMINADO("Registro eliminado con éxito", HttpStatus.OK),
  
  //ADVERTENCIAS / NEGOCIO.
  ADVERTENCIA_REGISTRO_ID_NO_ENCONTRADO(
      "No se encontró el Registro con el Id proporcionado.",
      HttpStatus.NOT_FOUND
  ),
  ADVERTENCIA_REGISTRO_YA_EXISTE(
      "Id del Registro ya existe en Base de Datos.",
      HttpStatus.CONFLICT
  ),
  
  //ERRORES.
  ERROR_REGISTRO_NO_ENCONTRADO(
      "Registro no encontrado.",
      HttpStatus.NOT_FOUND
  ),
  ERROR_NO_EXISTEN_REGISTROS(
      "No existen registros",
      HttpStatus.NOT_FOUND
  ),
  ERROR_STOCK_INSUFICIENTE(
      "Stock insuficiente o el producto no existe, verifique",
      HttpStatus.BAD_REQUEST
  ),
  ERROR_SISTEMA(
      "Error del sistema, contacte al administrador.",
      HttpStatus.INTERNAL_SERVER_ERROR
  );
  
  private final String mensaje;
  private final HttpStatus status;
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param mensaje Texto descriptivo del mensaje de respuesta.
  * @param status Código HTTP asociado al mensaje.
  * Constructor del enum que asigna el mensaje y el estado HTTP.
  */
  MensajeRespuesta(String mensaje, HttpStatus status) {
    this.mensaje = mensaje;
    this.status = status;
  }
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @return mensaje Retorna el texto descriptivo del mensaje de respuesta.
  */
  public String getMensaje() {
    return mensaje;
  }
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @return status Retorna el código de estado HTTP asociado al mensaje.
  */
  public HttpStatus getStatus() {
    return status;
  }
}
