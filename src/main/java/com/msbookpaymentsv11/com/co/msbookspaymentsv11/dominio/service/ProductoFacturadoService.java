//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.ProductoFacturado;
import java.util.List;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de los métodos de respuesta en la interface para los cruds
* (creación, lectura, edición y eliminación) de un producto facturado.
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProductoFacturadoService {
  //DECLARACIÓN DE LOS MÉTODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS:
  //MÉTODO PARA CREAR UN PRODUCTO FACTURADO:
  MessageResponseDTO crearProductoFacturado(ProductoFacturadoDTO productoFacturadoDTO);
  //MÉTODO PARA ELIMINAR UN PRODUCTO FACTURADO POR SU ID:
  void eliminarProductoFacturado(Long idProductoFacturado);
  //MÉTODO PARA CONTAR CUÁNTOS PRODUCTOS FACTURADOS HAY POR ID DE LIBRO:
  Integer cuantosProductosFacturadosPorIdLibro(Long idLibro);
  //MÉTODO PARA LISTAR LOS PRODUCTOS FACTURADOS POR ID DE VENTA:
  List<ProductoFacturadoDTO> listaProductosFacturadosXIdVenta(Long idVenta);
  //MÉTODO PARA ACTUALIZAR PARCIALMENTE UN PRODUCTO FACTURADO:
  MessageResponseDTO actualizacionParcialProductoFacturado(Long idProductoFacturado, ProductoFacturadoDTO productoFacturadoDTO);
}
