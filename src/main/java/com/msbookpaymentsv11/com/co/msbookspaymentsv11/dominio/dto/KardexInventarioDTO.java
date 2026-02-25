//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del DTO para el kardex de inventario utilizado al registrar
* entradas y salidas de inventario en el microservicio de catálogo.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
public class KardexInventarioDTO {
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DEL DTO:
  private Long idLibro;
  private Integer cantidadInventario;
}
