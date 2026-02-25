//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del DTO para los productos facturados dentro de una venta.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
public class ProductoFacturadoDTO {
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO:
  @Schema(description = "ID generado automáticamente (NO ENVIAR)", example = "1")
  private Long idProductoFacturado;
  @Schema(description = "ID de la venta (tiene que existir una venta)", example = "1")
  private Long idVenta;
  @Schema(description = "ID del libro, compara con uno existente", example = "1")
  private Long idLibro;
  @Schema(description = "Cantidad de libros para comprar compara con stock", example = "1")
  private Integer cantidadItem;
  @Schema(description = "Precio unitario que trae de catalogue", example = "1")
  private double precioUnitarioLibro;
  @Schema(description = "Estado por default ACTIVO (NO ENVIAR)", example = "ACTIVO")
  private String estadoProductoFacturado;
  private String tituloLibro;
  private String codigoImagen;
  private String modalidad;
}
