package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.serviceImpl;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.exception.BusinessException;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.MensajeRespuesta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service.UsuarioService;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.dao.UsuarioDAO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Usuario;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
  @Autowired
  private UsuarioDAO usuarioDAO;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public List<UsuarioDTO> listarUsuarios() {
    List<Usuario> usuarios = usuarioRepository.findAll();

    if (usuarios.isEmpty()) {
      throw new BusinessException(MensajeRespuesta.ERROR_NO_EXISTEN_REGISTROS);
    }

    return usuarios.stream().map(usuarioDAO::usuarioDTO).toList();
  }

  @Override
  public MessageResponseDTO crearUsuario(UsuarioDTO usuarioDTO) {
    Usuario nuevoUsuario = usuarioRepository.save(usuarioDAO.usuario(usuarioDTO));
    return MessageResponseDTO.builder()
        .status(MensajeRespuesta.EXITO_REGISTRO_CREADO.getStatus())
        .message(MensajeRespuesta.EXITO_REGISTRO_CREADO.getMensaje())
        .idCreated(nuevoUsuario.getIdUsuario())
        .build();
  }

  @Override
  public void eliminarUsuario(Long idUsuario) {
    Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);
    if (usuarioId.isEmpty()) {
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }
    usuarioRepository.delete(usuarioId.get());
  }

  @Override
  public UsuarioDTO consultarUsuarioPorId(Long idUsuario) {
    Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
    if (usuario.isEmpty()) {
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }
    return usuarioDAO.usuarioDTO(usuario.get());
  }

  @Override
  public MessageResponseDTO actualizarUsuarioParcial(long idUsuario, UsuarioDTO usuarioDTO) {
    Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);

    if (usuarioId.isEmpty()) {
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }

    Usuario usuario = usuarioId.get();

    if (usuarioDTO.getCorreoUsuario() != null) {
      usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
    }

    if (usuarioDTO.getIdRolUsuario() != null) {
      usuario.setIdRolUsuario(usuarioDTO.getIdRolUsuario());
    }

    if (usuarioDTO.getEstadoUsuario() != null) {
      usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
    }

    if (usuarioDTO.getClaveUsuario() != null) {
      usuario.setClaveUsuario(usuarioDTO.getClaveUsuario());
    }

    usuarioRepository.save(usuario);

    return MessageResponseDTO.builder()
        .status(MensajeRespuesta.EXITO_REGISTRO_ACTUALIZADO.getStatus())
        .message(MensajeRespuesta.EXITO_REGISTRO_ACTUALIZADO.getMensaje())
        .idCreated(idUsuario)
        .build();
  }

  @Override
  public MessageResponseDTO actualizarUsuario(Long idUsuario, UsuarioDTO usuarioDTO) {
    Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);

    if (usuarioId.isEmpty()) {
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }

    Usuario usuario = usuarioId.get();

    usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
    usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
    usuario.setIdRolUsuario(usuarioDTO.getIdRolUsuario());

    usuarioRepository.save(usuario);

    return MessageResponseDTO.builder()
        .status(MensajeRespuesta.EXITO_REGISTRO_ACTUALIZADO.getStatus())
        .message(MensajeRespuesta.EXITO_REGISTRO_ACTUALIZADO.getMensaje())
        .idCreated(idUsuario)
        .build();
  }


}
