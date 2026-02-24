package com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.exception;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.MensajeRespuesta;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final MensajeRespuesta MensajeRespuesta;

  public BusinessException(MensajeRespuesta MensajeRespuesta) {
    super(MensajeRespuesta.getMensaje());
    this.MensajeRespuesta = MensajeRespuesta;
  }
}
