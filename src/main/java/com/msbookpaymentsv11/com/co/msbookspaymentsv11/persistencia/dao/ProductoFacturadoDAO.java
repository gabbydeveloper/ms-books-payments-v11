//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.ProductoFacturado;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.entity.Venta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración del método DAO para la conversión entre entidades y DTOs
* del producto facturado.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS MÉTODOS DEL DAO.
public class ProductoFacturadoDAO {
  
  @Autowired//INYECTAMOS EL REPOSITORIO DE VENTA PARA OBTENER LA RELACIÓN.
  private VentaRepository ventaRepository;
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param productoFacturadoDTO DTO con los datos del producto facturado a guardar.
  * @return productoFacturado Entidad con los datos convertidos desde el DTO.
  * Recibe un DTO para crear un objeto ProductoFacturado (conversión DTO → ENTITY).
  */
  //MÉTODO PARA GUARDAR LOS DATOS. SE HACE LA CONVERSIÓN DTO → ENTITY:
  public ProductoFacturado productoFacturado(ProductoFacturadoDTO productoFacturadoDTO){
    ProductoFacturado productoFacturado = new ProductoFacturado();
    //Reasigna columnas para conversión DTO → ENTITY:
    productoFacturado.setIdProductoFacturado(productoFacturadoDTO.getIdProductoFacturado());
    productoFacturado.setIdLibro(productoFacturadoDTO.getIdLibro());
    
    Venta venta = ventaRepository.findById(productoFacturadoDTO.getIdVenta()).orElseThrow(() -> new IllegalStateException("El código de la venta no existe. Verifique!"));
    productoFacturado.setVenta(venta);
    productoFacturado.setCantidadItem(productoFacturadoDTO.getCantidadItem());
    productoFacturado.setPrecioUnitarioLibro(productoFacturadoDTO.getPrecioUnitarioLibro());
    productoFacturado.setEstadoProductoFacturado("ACTIVO");
    productoFacturado.setTituloLibro(productoFacturadoDTO.getTituloLibro());
    productoFacturado.setCodigoImagen(productoFacturadoDTO.getCodigoImagen());
    productoFacturado.setModalidad(productoFacturadoDTO.getModalidad());
    
    return productoFacturado;
  }
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @param productoFacturado Entidad con los datos del producto facturado.
  * @return productoFacturadoDTO DTO con los datos convertidos desde la entidad.
  * Recibe una entidad para crear un DTO de ProductoFacturado (conversión ENTITY → DTO).
  */
  //MÉTODO PARA PRESENTAR LOS DATOS. SE HACE LA CONVERSIÓN ENTITY → DTO:
  public ProductoFacturadoDTO productoFacturadoDTO(ProductoFacturado productoFacturado){
    ProductoFacturadoDTO productoFacturadoDTO = new ProductoFacturadoDTO();
    //Reasigna columnas para conversión ENTITY → DTO:
    productoFacturadoDTO.setIdVenta(productoFacturado.getVenta().getIdVenta());
    productoFacturadoDTO.setIdProductoFacturado(productoFacturado.getIdProductoFacturado());
    productoFacturadoDTO.setIdLibro(productoFacturado.getIdLibro());
    productoFacturadoDTO.setCantidadItem(productoFacturado.getCantidadItem());
    productoFacturadoDTO.setPrecioUnitarioLibro(productoFacturado.getPrecioUnitarioLibro());
    productoFacturadoDTO.setEstadoProductoFacturado(productoFacturado.getEstadoProductoFacturado());
    productoFacturadoDTO.setTituloLibro(productoFacturado.getTituloLibro());
    productoFacturadoDTO.setCodigoImagen(productoFacturado.getCodigoImagen());
    productoFacturadoDTO.setModalidad(productoFacturado.getModalidad());
    
    return productoFacturadoDTO;
  }
}
