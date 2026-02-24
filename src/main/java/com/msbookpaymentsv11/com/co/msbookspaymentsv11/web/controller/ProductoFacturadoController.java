package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service.ProductoFacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoFacturadoController {

  @Autowired
  ProductoFacturadoService productoFacturadoService;

  @GetMapping("/facturados/{idLibro}")
  public Integer cuantosLibrosFacturados(@PathVariable Long idLibro) {
    return productoFacturadoService.cuantosProductosFacturadosPorIdLibro(idLibro);
  }

  @GetMapping("/{idVenta}")
  public ResponseEntity<List<ProductoFacturadoDTO>> productosPorVenta(@PathVariable Long idVenta) {
    List<ProductoFacturadoDTO> productos = productoFacturadoService.listaProductosFacturadosXIdVenta(idVenta);
    return new ResponseEntity<>(productos, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MessageResponseDTO> crearProducto(@RequestBody ProductoFacturadoDTO productoFacturadoDTO) {
    MessageResponseDTO messageResponseDTO = productoFacturadoService.crearProductoFacturado(productoFacturadoDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }

  @DeleteMapping("{idProductoFacturado}")
  public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProductoFacturado) {
    productoFacturadoService.eliminarProductoFacturado(idProductoFacturado);
    return ResponseEntity.ok().build();
  }

}
