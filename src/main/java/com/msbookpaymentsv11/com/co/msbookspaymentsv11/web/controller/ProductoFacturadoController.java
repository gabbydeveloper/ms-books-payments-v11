//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service.ProductoFacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del controlador para los productos facturados.
*/
@RestController//DECLARACIÓN DEL CONTROLADOR PARA LOS CRUDS.
@RequestMapping("/productos")//RUTA BASE DEL CONTROLADOR.
public class ProductoFacturadoController {
  
  @Autowired//INYECTAMOS EL SERVICIO.
  ProductoFacturadoService productoFacturadoService;
  
  //CONTROLADORES DE CRUDS (CREACIÓN, LECTURA, EDICIÓN Y ELIMINACIÓN DE UN REGISTRO).
  
  //LEER CONSULTA: CUÁNTOS LIBROS FACTURADOS HAY POR ID DE LIBRO:
  @GetMapping("/facturados/{idLibro}")//DECLARACIÓN DEL MAPEO DEL CRUD CONSULTAR REGISTRO.
  public Integer cuantosLibrosFacturados(@PathVariable Long idLibro) {
    return productoFacturadoService.cuantosProductosFacturadosPorIdLibro(idLibro);
  }
  
  //LEER LISTA DE PRODUCTOS FACTURADOS POR ID DE VENTA:
  @GetMapping("/{idVenta}")//DECLARACIÓN DEL MAPEO DEL CRUD LISTAR REGISTROS.
  public ResponseEntity<List<ProductoFacturadoDTO>> productosPorVenta(@PathVariable Long idVenta) {
    List<ProductoFacturadoDTO> productos = productoFacturadoService.listaProductosFacturadosXIdVenta(idVenta);
    return new ResponseEntity<>(productos, HttpStatus.OK);
  }
  
  //CREAR REGISTRO:
  @PostMapping//DECLARACIÓN DEL MAPEO DEL CRUD CREAR REGISTRO.
  public ResponseEntity<MessageResponseDTO> crearProducto(@RequestBody ProductoFacturadoDTO productoFacturadoDTO) {
    MessageResponseDTO messageResponseDTO = productoFacturadoService.crearProductoFacturado(productoFacturadoDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
  
  //ELIMINAR REGISTRO:
  @DeleteMapping("{idProductoFacturado}")//DECLARACIÓN DEL MAPEO DEL CRUD ELIMINAR REGISTRO.
  public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProductoFacturado) {
    productoFacturadoService.eliminarProductoFacturado(idProductoFacturado);
    return ResponseEntity.ok().build();
  }
  
  //MODIFICAR PARCIALMENTE REGISTRO:
  @PatchMapping("/{idProductoFacturado}")//DECLARACIÓN DEL MAPEO DEL CRUD MODIFICAR PARCIALMENTE REGISTRO.
  public ResponseEntity<MessageResponseDTO> actualizacionParcialProducto(@PathVariable Long idProductoFacturado, @RequestBody ProductoFacturadoDTO productoFacturadoDTO) {
    MessageResponseDTO messageResponseDTO = productoFacturadoService.actualizacionParcialProductoFacturado(idProductoFacturado, productoFacturadoDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
}
