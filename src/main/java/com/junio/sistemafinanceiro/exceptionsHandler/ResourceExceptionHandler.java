package com.junio.sistemafinanceiro.exceptionsHandler;

import com.junio.sistemafinanceiro.exceptionsHandler.exceptions.DatabaseException;
import com.junio.sistemafinanceiro.exceptionsHandler.exceptions.ResourceNotFoundException;
import com.junio.sistemafinanceiro.exceptionsHandler.exceptions.DadoInvalidoException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class ResourceExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ResourceExceptionHandler.class);

    private static final Map<Class<? extends Exception>, HttpStatusWrapper> exceptionMap = new HashMap<>();

    static {
        exceptionMap.put(ResourceNotFoundException.class, new HttpStatusWrapper(HttpStatus.NOT_FOUND, "Recurso não encontrado"));
        exceptionMap.put(DatabaseException.class, new HttpStatusWrapper(HttpStatus.BAD_REQUEST, "Violação da Integridade do Banco de Dados"));
        exceptionMap.put(SQLIntegrityConstraintViolationException.class, new HttpStatusWrapper(HttpStatus.BAD_REQUEST, "Violação de restrição de integridade do banco de dados"));
        exceptionMap.put(DataIntegrityViolationException.class, new HttpStatusWrapper(HttpStatus.BAD_REQUEST, "Violação de integridade de dados"));
        exceptionMap.put(MethodArgumentNotValidException.class, new HttpStatusWrapper(HttpStatus.BAD_REQUEST, "Dados inconsistentes com o formato ou tamanho permitido para a coluna"));
        exceptionMap.put(DadoInvalidoException.class, new HttpStatusWrapper(HttpStatus.BAD_REQUEST, "Dados inválidos fornecidos"));
        exceptionMap.put(UnexpectedTypeException.class, new HttpStatusWrapper(HttpStatus.BAD_REQUEST, "Tipo de dado inesperado fornecido"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e, HttpServletRequest request) {

        HttpStatusWrapper statusWrapper = exceptionMap.getOrDefault(e.getClass(), new HttpStatusWrapper(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"));

        // Logar o stack trace completo para fins de depuração
        logger.error("Error: ", e);

        StandardError error = new StandardError(Instant.now(),
                statusWrapper.getStatus().value(),
                statusWrapper.getMessage(), //enviar mesnagem do status
                request.getRequestURI());

        return ResponseEntity.status(statusWrapper.getStatus()).body(error);
    }
}
