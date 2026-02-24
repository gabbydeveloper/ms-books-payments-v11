package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes.EstadoVenta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VentaRepository extends JpaRepository <Venta, Long> {
    List<Venta> findByIdUsuario(Long idUsuario);
    Optional<Venta> findByIdUsuarioAndEstadoVenta(Long idUsuario, EstadoVenta estadoVenta);
}
