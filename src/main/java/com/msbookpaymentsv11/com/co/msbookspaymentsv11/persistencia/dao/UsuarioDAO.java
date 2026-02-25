//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Usuario;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.utils.PasswordGenerator;
import org.springframework.stereotype.Component;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del método DAO para la conversión entre entidades y DTOs
* del usuario.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS MÉTODOS DEL DAO.
public class UsuarioDAO {
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param usuarioDTO DTO con los datos del usuario a guardar.
  * @return usuario Entidad con los datos convertidos desde el DTO.
  * Recibe un DTO para crear un objeto Usuario (conversión DTO → ENTITY).
  */
  //MÉTODO PARA GUARDAR LOS DATOS. SE HACE LA CONVERSIÓN DTO → ENTITY:
  public Usuario usuario(UsuarioDTO usuarioDTO){
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(usuarioDTO.getIdUsuario());
    //Por default va el ROL 2 que es el de usuario que ingresa a la plataforma:
    usuario.setIdRolUsuario(2L);
    usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
    
    String claveGenerada = PasswordGenerator.generateRandomPassword();
    
    usuario.setClaveUsuario(claveGenerada);
    usuario.setEstadoUsuario("ACTIVO");
    
    usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
    usuario.setApellidoUsuario(usuarioDTO.getApellidoUsuario());
    usuario.setTelefonoUsuario(usuarioDTO.getTelefonoUsuario());
    
    return usuario;
  }
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param usuario Entidad con los datos del usuario.
  * @return usuarioDTO DTO con los datos convertidos desde la entidad.
  * Recibe una entidad para crear un DTO de Usuario (conversión ENTITY → DTO).
  */
  //MÉTODO PARA PRESENTAR LOS DATOS. SE HACE LA CONVERSIÓN ENTITY → DTO:
  public UsuarioDTO usuarioDTO(Usuario usuario){
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setIdUsuario(usuario.getIdUsuario());
    usuarioDTO.setIdRolUsuario(usuario.getIdRolUsuario());
    usuarioDTO.setCorreoUsuario(usuario.getCorreoUsuario());
    usuarioDTO.setClaveUsuario("************");
    usuarioDTO.setEstadoUsuario(usuario.getEstadoUsuario());
    usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
    usuarioDTO.setApellidoUsuario(usuario.getApellidoUsuario());
    usuarioDTO.setTelefonoUsuario(usuario.getTelefonoUsuario());
    
    return  usuarioDTO;
  }
}
