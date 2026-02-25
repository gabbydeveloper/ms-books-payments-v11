package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.VentaDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
  @Autowired
  private VentaService ventaService;

  @PostMapping
  public ResponseEntity<MessageResponseDTO> crearVenta(@RequestBody VentaDTO ventaDTO) {
    MessageResponseDTO messageResponseDTO = ventaService.crearVenta(ventaDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }

  @GetMapping("/usuario/{idUsuario}")
  public ResponseEntity<List<VentaDTO>> listarVentasByIdUsuario(@PathVariable Long idUsuario) {
    List<VentaDTO> ventas = ventaService.listarVentasPorIdUsuario(idUsuario);
    return new ResponseEntity<>(ventas, HttpStatus.OK);
  }

  @PatchMapping("/{idVenta}")
  public ResponseEntity<MessageResponseDTO> actualizarVenta(@PathVariable Long idVenta, @RequestBody VentaDTO ventaDTO) {
    MessageResponseDTO messageResponseDTO = ventaService.actualizarVenta(idVenta, ventaDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }

  @GetMapping("/ingresada/usuario/{idUsuario}")
  public ResponseEntity<VentaDTO> ventaIngresadaPorUsuario(@PathVariable Long idUsuario){
    VentaDTO ventaDTO = ventaService.obtenerVentaIngresada(idUsuario);
    return ResponseEntity.ok(ventaDTO);
  }

  @GetMapping("/cuantositems/usuario/{idUsuario}")
  public ResponseEntity<Integer> cuantosItemsVentaPorUsuario(@PathVariable Long idUsuario){
    Integer cuantos = ventaService.cuantosItemsVentaUsuario(idUsuario);
    return ResponseEntity.ok(cuantos);
  }

}
