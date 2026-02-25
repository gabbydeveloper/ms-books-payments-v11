package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.ProductoFacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoFacturadoRepository extends JpaRepository<ProductoFacturado, Long> {

  @Query(nativeQuery = true, value = "SELECT SUM(id_libro) FROM tbl_productos_facturados WHERE id_libro = :idLibro")
  Integer cuantosLibrosFacturadosXIdLibro(@Param("idLibro") Long idLibro);

  @Query(nativeQuery = true, value = "SELECT * FROM tbl_productos_facturados WHERE id_venta = :idVenta")
  List<ProductoFacturado> productosPorIdVenta(@Param("idVenta") Long idVenta);

  @Query("""
            SELECT p FROM ProductoFacturado p
            WHERE p.venta.idVenta = :idVenta
            AND p.idLibro = :idLibro
        """)
  Optional<ProductoFacturado> buscarExistente(
      @Param("idVenta") Long idVenta,
      @Param("idLibro") Long idLibro);

}
