//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.VentaDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del controlador para las ventas.
*/
@RestController//DECLARACIÓN DEL CONTROLADOR PARA LOS CRUDS.
@RequestMapping("/ventas")//RUTA BASE DEL CONTROLADOR.
public class VentaController {
  
  @Autowired//INYECTAMOS EL SERVICIO.
  private VentaService ventaService;
  
  //CONTROLADORES DE CRUDS (CREACIÓN, LECTURA Y EDICIÓN DE UN REGISTRO).
  
  //CREAR REGISTRO:
  @PostMapping//DECLARACIÓN DEL MAPEO DEL CRUD CREAR REGISTRO.
  public ResponseEntity<MessageResponseDTO> crearVenta(@RequestBody VentaDTO ventaDTO) {
    MessageResponseDTO messageResponseDTO = ventaService.crearVenta(ventaDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
  
  //LEER LISTA DE VENTAS POR ID DE USUARIO:
  @GetMapping("/usuario/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD LISTAR REGISTROS POR USUARIO.
  public ResponseEntity<List<VentaDTO>> listarVentasByIdUsuario(@PathVariable Long idUsuario) {
    List<VentaDTO> ventas = ventaService.listarVentasPorIdUsuario(idUsuario);
    return new ResponseEntity<>(ventas, HttpStatus.OK);
  }
  
  //MODIFICAR REGISTRO:
  @PatchMapping("/{idVenta}")//DECLARACIÓN DEL MAPEO DEL CRUD MODIFICAR REGISTRO.
  public ResponseEntity<MessageResponseDTO> actualizarVenta(@PathVariable Long idVenta, @RequestBody VentaDTO ventaDTO) {
    MessageResponseDTO messageResponseDTO = ventaService.actualizarVenta(idVenta, ventaDTO);
    return ResponseEntity.ok(messageResponseDTO);
  }
  
  //LEER CONSULTA DE LA VENTA EN ESTADO INGRESADA POR ID DE USUARIO:
  @GetMapping("/ingresada/usuario/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD CONSULTAR VENTA INGRESADA.
  public ResponseEntity<VentaDTO> ventaIngresadaPorUsuario(@PathVariable Long idUsuario){
    VentaDTO ventaDTO = ventaService.obtenerVentaIngresada(idUsuario);
    return ResponseEntity.ok(ventaDTO);
  }
  
  //LEER CONSULTA: CUÁNTOS ÍTEMS TIENE LA VENTA DEL USUARIO:
  @GetMapping("/cuantositems/usuario/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD CONSULTAR CANTIDAD DE ÍTEMS.
  public ResponseEntity<Integer> cuantosItemsVentaPorUsuario(@PathVariable Long idUsuario){
    Integer cuantos = ventaService.cuantosItemsVentaUsuario(idUsuario);
    return ResponseEntity.ok(cuantos);
  }
}
