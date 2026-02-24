package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto;

import lombok.Data;
import java.util.List;

@Data
public class RespuestaDTO {

  private VentaDTO ventaDTO;
  private List<UsuarioDTO> usuariosDTO;
  private List<VentaDTO> ventasDTO;

  public RespuestaDTO() {
  }
}
