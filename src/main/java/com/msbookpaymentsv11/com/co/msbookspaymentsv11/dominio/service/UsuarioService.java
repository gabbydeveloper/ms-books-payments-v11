//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import java.util.List;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de los métodos de respuesta en la interface para los cruds
* (creación, lectura, edición y eliminación) de un usuario.
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface UsuarioService {
  //DECLARACIÓN DE LOS MÉTODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS:
  //MÉTODO PARA LISTAR TODOS LOS USUARIOS:
  List<UsuarioDTO> listarUsuarios();
  //MÉTODO PARA CREAR UN USUARIO:
  MessageResponseDTO crearUsuario(UsuarioDTO usuarioDTO);
  //MÉTODO PARA ELIMINAR UN USUARIO POR SU ID:
  void eliminarUsuario(Long idUsuario);
  //MÉTODO PARA CONSULTAR UN USUARIO POR SU ID:
  UsuarioDTO consultarUsuarioPorId(Long idUsuario);
  //MÉTODO PARA ACTUALIZAR PARCIALMENTE UN USUARIO POR SU ID:
  MessageResponseDTO actualizarUsuarioParcial(long idUsuario, UsuarioDTO usuarioDTO);
  //MÉTODO PARA ACTUALIZAR TODOS LOS DATOS DE UN USUARIO:
  MessageResponseDTO actualizarUsuario(Long idUsuario, UsuarioDTO usuarioDTO);
}
