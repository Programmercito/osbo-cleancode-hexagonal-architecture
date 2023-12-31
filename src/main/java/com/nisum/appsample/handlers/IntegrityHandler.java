package com.nisum.appsample.handlers;

import java.util.HashMap;
import java.util.Map;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase proporciona un controlador para manejar excepciones de violación
 * de integridad.
 * @author programmercito
 */
@ControllerAdvice
public class IntegrityHandler {

    /**
     * Este método maneja excepciones de violación de integridad.
     *
     * @param ex La excepción que se ha producido.
     * @return Un mapa que contiene un mensaje de error.
     */
    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleJdbcSQLIntegrityConstraintViolationException(JdbcSQLIntegrityConstraintViolationException ex) {
        Map<String, String> response = new HashMap<>();
        String mensaje = ex.getMessage();
        if (mensaje.contains("PUBLIC.UK_") && mensaje.contains("PUBLIC.USUARIO(EMAIL")) {
            response.put("mensaje", "El correo ya registrado");
        } else {
            response.put("mensaje", "Problemas en la base de datos");
        }
        return response;
    }
}
