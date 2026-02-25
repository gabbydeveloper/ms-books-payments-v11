//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Repositorio JPA para la entidad Usuario.
* Hereda los métodos CRUD básicos de JpaRepository.
*/
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
