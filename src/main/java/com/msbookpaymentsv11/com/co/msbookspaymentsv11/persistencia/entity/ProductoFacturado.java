//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import jakarta.persistence.*;
import lombok.Data;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de la entidad JPA para la tabla TBL_PRODUCTOS_FACTURADOS.
* Representa cada ítem de libro incluido dentro de una venta.
*/
@Entity//DECLARACIÓN DE LA ENTIDAD PARA MAPEAR LA TABLA DE LA BASE DE DATOS.
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA (ÍNDICE) DE LA BASE DE DATOS PARA LA ENTIDAD.
@Table(name="TBL_PRODUCTOS_FACTURADOS")//NOMBRE DE LA TABLA EN LA BASE DE DATOS.
public class ProductoFacturado {

  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS:
  @Id//LLAVE PRIMARIA DE LA TABLA.
  @GeneratedValue(strategy = GenerationType.IDENTITY)//GENERACIÓN AUTOMÁTICA DEL ID.
  @Column(name="ID_PRODUCTO_FACTURADO")
  private Long idProductoFacturado;
  
  @ManyToOne(fetch = FetchType.LAZY)//RELACIÓN MUCHOS PRODUCTOS A UNA VENTA.
  @JoinColumn(name = "ID_VENTA", nullable = false)
  private Venta venta;
  
  @Column(name="ID_LIBRO")
  private Long idLibro;
  
  @Column(name="CANTIDAD_ITEM")
  private Integer cantidadItem;
  
  @Column(name="PRECIO_UNITARIO_LIBRO")
  private double precioUnitarioLibro;
  
  @Column(name="ESTADO_PRODUCTO_FACTURADO")
  private String estadoProductoFacturado;
  
  @Column(name="TITULO_LIBRO")
  private String tituloLibro;
  
  @Column(name="CODIGO_IMAGEN")
  private String codigoImagen;
  
  @Column(name="MODALIDAD")
  private String modalidad;
}
