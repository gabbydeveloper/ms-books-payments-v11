package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
public class MessageResponseDTO {
  private HttpStatus status;
  private String message;
  private Long idCreated;
}
