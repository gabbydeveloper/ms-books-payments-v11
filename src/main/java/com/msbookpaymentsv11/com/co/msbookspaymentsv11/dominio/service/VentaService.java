//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.VentaDTO;
import java.util.List;
import java.util.Optional;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de los métodos de respuesta en la interface para los cruds
* (creación, lectura y edición) de una venta.
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface VentaService {
  //DECLARACIÓN DE LOS MÉTODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS:
  //MÉTODO PARA LISTAR VENTAS POR ID DE USUARIO:
  List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario);
  //MÉTODO PARA CREAR UNA VENTA:
  MessageResponseDTO crearVenta(VentaDTO ventaDTO);
  //MÉTODO PARA ACTUALIZAR UNA VENTA POR SU ID:
  MessageResponseDTO actualizarVenta(Long idVenta, VentaDTO ventaDTO);
  //MÉTODO PARA OBTENER LA VENTA EN ESTADO INGRESADA DE UN USUARIO:
  VentaDTO obtenerVentaIngresada(Long idUsuario);
  //MÉTODO PARA CONTAR CUÁNTOS ÍTEMS TIENE LA VENTA ACTIVA DE UN USUARIO:
  Integer cuantosItemsVentaUsuario(Long idUsuario);
}
