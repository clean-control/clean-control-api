package com.example.cleancontrol.api.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.cleancontrol.api.dto.exceptionsDto.ErrorResponseDTO;
import com.example.cleancontrol.api.exceptions.UnauthorizedException;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnauthorizedException(UnauthorizedException ex,  HttpServletRequest request) {

        String path = ex.getMessage();
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            HttpStatus.UNAUTHORIZED.value(),
             "Usuario não autenticado ou token nao localizado",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
path
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            404,
            ex.getMessage(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
            path
        );
System.out.println(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    // private Integer getStatusCode(Exception ex) {
        
    //     String message = ex.getMessage();
    //     while(message.length() > 3) {
            
    //     }

    // }



}