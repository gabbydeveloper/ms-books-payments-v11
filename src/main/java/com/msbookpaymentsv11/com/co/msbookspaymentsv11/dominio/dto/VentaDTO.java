//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del DTO para los datos de una venta realizada en el sistema.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
public class VentaDTO {
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO:
  @Schema(description = "ID generado automáticamente (NO ENVIAR)", example = "1")
  private Long idVenta;
  @Schema(description = "ID del usuario", example = "2")
  private Long idUsuario;
  @Schema(description = "Numero de orden", example = "4")
  private String numeroOrden;
  @Schema(description = "Fecha y hora en que realiza la venta", example ="2026-02-05T15:17:00")
  private LocalDateTime fechaVenta;
  @Schema(description = "Porcentaje de descuento de la venta", example = "0,1")
  private double porcentajeDescuento;
  @Schema(description = "Costo de envio de la venta", example = "5,00")
  private double costoEnvio;
  @Schema(description = "Estado de la venta (INGRESADA por default)", example = "INGRESADA/PAGADA/ANULADA")
  private String estadoVenta;
}
