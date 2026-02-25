package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.VentaDTO;

import java.util.List;
import java.util.Optional;

public interface VentaService {
  List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario);
  MessageResponseDTO crearVenta(VentaDTO ventaDTO);
  MessageResponseDTO actualizarVenta(Long idVenta, VentaDTO ventaDTO);
  VentaDTO obtenerVentaIngresada(Long idUsuario);
  Integer cuantosItemsVentaUsuario(Long idUsuario);
}
