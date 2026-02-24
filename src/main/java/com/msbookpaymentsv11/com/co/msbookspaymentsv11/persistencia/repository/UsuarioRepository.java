package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
