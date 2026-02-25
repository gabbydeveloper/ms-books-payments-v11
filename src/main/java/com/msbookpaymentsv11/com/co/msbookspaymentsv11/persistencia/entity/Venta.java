//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.EstadoVenta;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de la entidad JPA para la tabla TBL_VENTAS.
* Representa una venta realizada por un usuario en el sistema de pagos.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA (ÍNDICE) DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD PARA MAPEAR LA TABLA DE LA BASE DE DATOS.
@Table(name="TBL_VENTAS")//NOMBRE DE LA TABLA EN LA BASE DE DATOS.
public class Venta {
  
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS:
  @Id//LLAVE PRIMARIA DE LA TABLA.
  @GeneratedValue(strategy = GenerationType.IDENTITY)//GENERACIÓN AUTOMÁTICA DEL ID.
  @Column(name="ID_VENTA")
  private Long idVenta;
  
  @Column(name = "ID_USUARIO", nullable = false)
  private Long idUsuario;
  
  @Column(name="NUMERO_ORDEN", nullable = false)
  private String numeroOrden;
  
  @Column(name="FECHA_VENTA", nullable = false)
  private LocalDateTime fechaVenta;
  
  @Column(name="PORCENTAJE_DESCUENTO", nullable = false)
  private double porcentajeDescuento;
  
  @Column(name="COSTO_ENVIO", nullable = false)
  private double costoEnvio;
  
  @Enumerated(EnumType.STRING)//ALMACENA EL ENUM COMO CADENA DE TEXTO EN LA BASE DE DATOS.
  private EstadoVenta estadoVenta;
}
