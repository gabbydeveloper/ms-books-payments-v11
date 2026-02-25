package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.ProductoFacturado;

import java.util.List;

public interface ProductoFacturadoService {
  MessageResponseDTO crearProductoFacturado(ProductoFacturadoDTO productoFacturadoDTO);
  void eliminarProductoFacturado(Long idProductoFacturado);
  Integer cuantosProductosFacturadosPorIdLibro(Long idLibro);
  List<ProductoFacturadoDTO> listaProductosFacturadosXIdVenta(Long idVenta);
  MessageResponseDTO actualizacionParcialProductoFacturado(Long idProductoFacturado, ProductoFacturadoDTO productoFacturadoDTO);
}
