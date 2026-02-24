package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.dao;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.EstadoVenta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.VentaDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Venta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VentaDAO {

    public Venta venta(VentaDTO ventaDTO){
        Venta venta = new Venta();
       venta.setIdVenta(ventaDTO.getIdVenta());
        venta.setIdUsuario(ventaDTO.getIdUsuario());
        venta.setNumeroOrden(ventaDTO.getNumeroOrden());
        venta.setFechaVenta(LocalDateTime.now());
        venta.setPorcentajeDescuento(ventaDTO.getPorcentajeDescuento());
        venta.setCostoEnvio(ventaDTO.getCostoEnvio());
        venta.setEstadoVenta(EstadoVenta.valueOf(ventaDTO.getEstadoVenta()));
        return venta;
    }


    public VentaDTO ventaDTO(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setIdVenta(venta.getIdVenta());
        ventaDTO.setIdUsuario(venta.getIdUsuario());
        ventaDTO.setNumeroOrden(venta.getNumeroOrden());
        ventaDTO.setFechaVenta(venta.getFechaVenta());
        ventaDTO.setPorcentajeDescuento(venta.getPorcentajeDescuento());
        ventaDTO.setCostoEnvio(venta.getCostoEnvio());
        ventaDTO.setEstadoVenta(String.valueOf(venta.getEstadoVenta()));

        return ventaDTO;
    }
}
