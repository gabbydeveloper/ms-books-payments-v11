package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes.EstadoVenta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.exception.BusinessException;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes.MensajeRespuesta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.VentaDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
  @Autowired
  private VentaRepository ventaRepository;

  @Autowired
  private VentaDAO ventaDAO;

  @Override
  public List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario) {
    List<Venta> ventas = ventaRepository.findByIdUsuario(idUsuario);

    if(ventas.isEmpty()){
      throw new BusinessException(MensajeRespuesta.ERROR_NO_EXISTEN_REGISTROS);
    }

    return ventas.stream().map(ventaDAO::ventaDTO).toList();
  }

  @Override
  public MessageResponseDTO crearVenta(VentaDTO ventaDTO) {
    Venta nuevaVenta = ventaRepository.save(ventaDAO.venta(ventaDTO));

    return MessageResponseDTO.builder()
        .status(MensajeRespuesta.EXITO_REGISTRO_CREADO.getStatus())
        .message(MensajeRespuesta.EXITO_REGISTRO_CREADO.getMensaje())
        .idCreated(nuevaVenta.getIdVenta())
        .build();
  }

  @Override
  public MessageResponseDTO actualizarVenta(Long idVenta, VentaDTO ventaDTO) {
    Optional<Venta> ventaId = ventaRepository.findById(idVenta);

    if(ventaId.isEmpty()){
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }

    Venta venta = ventaId.get();

    if(ventaDTO.getEstadoVenta() != null){
      venta.setEstadoVenta(EstadoVenta.valueOf(ventaDTO.getEstadoVenta()));
    }

    if(ventaDTO.getCostoEnvio() != venta.getCostoEnvio()){
      venta.setCostoEnvio(ventaDTO.getCostoEnvio());
    }

    if(ventaDTO.getPorcentajeDescuento() != venta.getPorcentajeDescuento()){
      venta.setPorcentajeDescuento(ventaDTO.getPorcentajeDescuento());
    }

    if(ventaDTO.getNumeroOrden() != null){
      venta.setNumeroOrden(ventaDTO.getNumeroOrden());
    }

    return MessageResponseDTO.builder()
        .status(MensajeRespuesta.EXITO_REGISTRO_ACTUALIZADO.getStatus())
        .message(MensajeRespuesta.EXITO_REGISTRO_ACTUALIZADO.getMensaje())
        .idCreated(idVenta)
        .build();
  }

  @Override
  public VentaDTO obtenerVentaIngresada(Long idUsuario) {
    Optional<Venta> venta = ventaRepository.findByIdUsuarioAndEstadoVenta(idUsuario, EstadoVenta.INGRESADA);
    if (venta.isEmpty()) {
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }
    return ventaDAO.ventaDTO(venta.get());
  }
}
