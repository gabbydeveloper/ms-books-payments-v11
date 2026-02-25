//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del controlador para los usuarios.
*/
@RestController//DECLARACIÓN DEL CONTROLADOR PARA LOS CRUDS.
public class UsuarioController {
  
  @Autowired//INYECTAMOS EL SERVICIO.
  private UsuarioService usuarioService;
  
  //CONTROLADORES DE CRUDS (CREACIÓN, LECTURA, EDICIÓN Y ELIMINACIÓN DE UN REGISTRO).
  
  //LEER LISTA DE TODOS LOS USUARIOS:
  @Operation(
      summary = "Obtener una lista de usuarios",
      description = "Devuelve todos los usuarios inscritos en la base de datos"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Lista todos los usuarios"),
      @ApiResponse(responseCode = "404", description = "Si no hay usuarios")
  })
  @GetMapping("/usuarios")//DECLARACIÓN DEL MAPEO DEL CRUD LISTAR REGISTROS.
  public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
    List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
  }
  
  //LEER CONSULTA DE REGISTRO POR ID:
  @Operation(
      summary = "Presenta datos de un usuario",
      description = "Devuelve todos los datos de un usuario dado su código"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @GetMapping("/usuarios/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD CONSULTAR REGISTRO.
  public ResponseEntity<UsuarioDTO> consultarUsuarioPorId(@PathVariable Long idUsuario) {
    UsuarioDTO usuarioDTO = usuarioService.consultarUsuarioPorId(idUsuario);
    return ResponseEntity.ok(usuarioDTO);
  }
  
  //CREAR REGISTRO:
  @Operation(
      summary = "Crea un usuario",
      description = "Crea el usuario con el cuerpo JSON enviado"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario creado"),
      @ApiResponse(responseCode = "400", description = "Parámetros inválidos")
  })
  @PostMapping("/usuarios")//DECLARACIÓN DEL MAPEO DEL CRUD CREAR REGISTRO.
  public ResponseEntity<MessageResponseDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    MessageResponseDTO messageResponseDTO = usuarioService.crearUsuario(usuarioDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
  
  //ELIMINAR REGISTRO:
  @Operation(
      summary = "Elimina un usuario",
      description = "Elimina los datos de un usuario dado su código"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario eliminado"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @DeleteMapping("/usuarios/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD ELIMINAR REGISTRO.
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Long idUsuario) {
    usuarioService.eliminarUsuario(idUsuario);
    return ResponseEntity.ok().build();
  }
  
  //MODIFICAR PARCIALMENTE REGISTRO:
  @Operation(
      summary = "Actualización parcial de usuarios",
      description = "Actualiza uno o varios campos de un usuario dado su código"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @PatchMapping("/usuarios/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD MODIFICAR PARCIALMENTE REGISTRO.
  public ResponseEntity<MessageResponseDTO> actualizarUsuarioParcial(
      @PathVariable Long idUsuario,
      @RequestBody UsuarioDTO usuarioDTO) {
    MessageResponseDTO messageResponseDTO =
        usuarioService.actualizarUsuarioParcial(idUsuario, usuarioDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
  
  //MODIFICAR REGISTRO (ACTUALIZACIÓN COMPLETA):
  @Operation(
      summary = "Actualización de usuarios",
      description = "Actualiza todos los campos de un usuario dado su código, es obligatorio mandr todos los datos"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
      @ApiResponse(responseCode = "400", description = "Estructura mal formada o faltan datos"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @PutMapping("/usuarios/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD MODIFICAR REGISTRO.
  public ResponseEntity<MessageResponseDTO> actualizarUsuario(
      @PathVariable Long idUsuario,
      @RequestBody UsuarioDTO usuarioDTO) {
    MessageResponseDTO messageResponseDTO =
        usuarioService.actualizarUsuario(idUsuario, usuarioDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
}
