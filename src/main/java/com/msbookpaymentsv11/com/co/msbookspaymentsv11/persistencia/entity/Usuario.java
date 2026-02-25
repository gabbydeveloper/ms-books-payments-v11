//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import jakarta.persistence.*;
import lombok.Data;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de la entidad JPA para la tabla TBL_USUARIOS.
* Representa a los usuarios registrados en el sistema de pagos.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA (ÍNDICE) DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD PARA MAPEAR LA TABLA DE LA BASE DE DATOS.
@Table(name="TBL_USUARIOS")//NOMBRE DE LA TABLA EN LA BASE DE DATOS.
public class Usuario {
  
  //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS:
  @Id//LLAVE PRIMARIA DE LA TABLA.
  @GeneratedValue(strategy = GenerationType.IDENTITY)//GENERACIÓN AUTOMÁTICA DEL ID.
  @Column(name="ID_USUARIO")
  private Long idUsuario;
  
  @Column(name = "ID_ROL_USUARIO", nullable = false)
  private Long idRolUsuario;
  
  @Column(name="CORREO_USUARIO", nullable = false, unique = true)
  private String correoUsuario;
  
  @Column(name="CLAVE_USUARIO", nullable = false)
  private String claveUsuario;
  
  @Column(name="ESTADO_USUARIO", nullable = false)
  private String estadoUsuario;
  
  @Column(name="NOMBRE_USUARIO")
  private String nombreUsuario;
  
  @Column(name="APELLIDO_USUARIO")
  private String apellidoUsuario;
  
  @Column(name="TELEFONO_USUARIO")
  private String telefonoUsuario;
}
