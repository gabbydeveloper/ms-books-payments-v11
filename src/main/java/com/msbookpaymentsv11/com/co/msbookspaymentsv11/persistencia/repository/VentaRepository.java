package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.EstadoVenta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VentaRepository extends JpaRepository <Venta, Long> {
    List<Venta> findByIdUsuario(Long idUsuario);
    Optional<Venta> findByIdUsuarioAndEstadoVenta(Long idUsuario, EstadoVenta estadoVenta);
}
