//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del DTO para los datos del usuario del sistema.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
public class UsuarioDTO {
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO:
  @Schema(description = "ID generado automáticamente (NO ENVIAR)", example = "1")
  private Long idUsuario;
  @Schema(description = "ID del rol del usuario (2 por default NO ENVIAR)", example = "2")
  private Long idRolUsuario;
  @Schema(description = "Correo que ingresa el usuario al registrarse", example = "gabby@gmail.com")
  private String correoUsuario;
  @Schema(description = "Clave generada automáticamente (NO ENVIAR)")
  private String claveUsuario;
  @Schema(description = "Estado del usuario (ACTIVO por default NO ENVIAR)", example = "ACTIVO/INACTIVO")
  private String estadoUsuario;
  private String nombreUsuario;
  private String apellidoUsuario;
  private String telefonoUsuario;
}
