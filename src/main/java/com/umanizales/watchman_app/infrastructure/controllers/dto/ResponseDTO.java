package com.umanizales.watchman_app.infrastructure.controllers.dto;

import com.umanizales.watchman_app.infrastructure.controllers.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
    private List<ErrorDTO> errors;
}