//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.EstadoVenta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.VentaDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Venta;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del método DAO para la conversión entre entidades y DTOs
* de la venta.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS MÉTODOS DEL DAO.
public class VentaDAO {
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param ventaDTO DTO con los datos de la venta a guardar.
  * @return venta Entidad con los datos convertidos desde el DTO.
  * Recibe un DTO para crear un objeto Venta (conversión DTO → ENTITY).
  */
  //MÉTODO PARA GUARDAR LOS DATOS. SE HACE LA CONVERSIÓN DTO → ENTITY:
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
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param venta Entidad con los datos de la venta.
  * @return ventaDTO DTO con los datos convertidos desde la entidad.
  * Recibe una entidad para crear un DTO de Venta (conversión ENTITY → DTO).
  */
  //MÉTODO PARA PRESENTAR LOS DATOS. SE HACE LA CONVERSIÓN ENTITY → DTO:
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
