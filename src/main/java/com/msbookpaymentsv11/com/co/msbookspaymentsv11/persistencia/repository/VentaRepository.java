package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.EstadoVenta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VentaRepository extends JpaRepository <Venta, Long> {
    List<Venta> findByIdUsuario(Long idUsuario);
    Optional<Venta> findByIdUsuarioAndEstadoVenta(Long idUsuario, EstadoVenta estadoVenta);

    @Query(nativeQuery = true, value = "SELECT IFNULL(SUM(p.cantidad_item),0)" +
                                       "  FROM tbl_ventas v, tbl_productos_facturados p" +
                                       " WHERE v.id_venta = p.id_venta" +
                                       "   AND v.estado_venta = 'INGRESADA'" +
                                       "   AND v.id_usuario = :idUsuario")
    Integer cuantosItemsXVentaIngresadaXUsuario(@Param("idUsuario") Long idUsuario);
}
