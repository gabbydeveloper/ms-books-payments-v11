//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import java.util.List;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del DTO de respuesta general que agrupa datos de ventas y usuarios.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
public class RespuestaDTO {
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DEL DTO:
  private VentaDTO ventaDTO;
  private List<UsuarioDTO> usuariosDTO;
  private List<VentaDTO> ventasDTO;
  
  public RespuestaDTO() {
  }
}
