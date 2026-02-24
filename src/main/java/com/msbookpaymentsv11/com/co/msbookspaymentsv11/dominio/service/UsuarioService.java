package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
  //Creación de la lista para el GET
  List<UsuarioDTO> listarUsuarios();
  //Declara el método para crear usuario
  MessageResponseDTO crearUsuario(UsuarioDTO usuarioDTO);
  //Declara el método para eliminar usuario
  void eliminarUsuario(Long idUsuario);
  //Método que consulta un usuario por ID
  UsuarioDTO consultarUsuarioPorId(Long idUsuario);
  //Método para actualizar un usuario parcialmente por su ID
  MessageResponseDTO actualizarUsuarioParcial(long idUsuario, UsuarioDTO usuarioDTO);
  //Método para actualizar todos los datos del usuario
  MessageResponseDTO actualizarUsuario(Long idUsuario, UsuarioDTO usuarioDTO);
}
