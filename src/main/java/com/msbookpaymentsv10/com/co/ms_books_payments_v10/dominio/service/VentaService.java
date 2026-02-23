package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;

import java.util.List;
import java.util.Optional;

public interface VentaService {
  List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario);
  MessageResponseDTO crearVenta(VentaDTO ventaDTO);
  MessageResponseDTO actualizarVenta(Long idVenta, VentaDTO ventaDTO);
  VentaDTO obtenerVentaIngresada(Long idUsuario);
}
