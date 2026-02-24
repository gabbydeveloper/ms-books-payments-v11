package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.EstadoVenta;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="TBL_VENTAS")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private EstadoVenta estadoVenta;
}

