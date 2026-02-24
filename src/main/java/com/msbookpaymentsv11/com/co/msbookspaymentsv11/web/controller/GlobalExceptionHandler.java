package com.msbookpaymentsv11.com.co.msbookspaymentsv11.web.controller;

import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.exception.BusinessException;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.Constantes.MensajeRespuesta;
import com.msbookpaymentsv11.com.co.msbookspaymentsv11.dominio.dto.MessageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<MessageResponseDTO> handleBusiness(BusinessException ex) {

    MensajeRespuesta msg = ex.getMensajeRespuesta();

    MessageResponseDTO error = new MessageResponseDTO(
        msg.getStatus(),
        msg.getMensaje(),
        null
    );

    return new ResponseEntity<>(error, msg.getStatus());

  }
}
