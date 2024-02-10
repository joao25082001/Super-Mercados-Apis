package org.example.handler;

import org.example.DTO.ExceptionDTO;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionBadRequest;
import org.example.exception.ExceptionConflict;
import org.example.exception.ExeceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RegrasNegocioException {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ExceptionConflict.class})
    public ExceptionDTO handler(ExceptionConflict ex){
        return new ExceptionDTO(
                ex.getMessage()
        );

    }
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ExceptionBadRequest.class})
    public ExceptionDTO handler(ExceptionBadRequest ex){
        return new ExceptionDTO(
                ex.getMessage()
        );

    }
    @ResponseBody
    @ExceptionHandler({ExceptioNoContent.class})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ExceptionDTO handler(ExceptioNoContent ex){
        return new ExceptionDTO(
                ex.getMessage()
        );

    }
    @ResponseBody
    @ExceptionHandler({ExeceptionNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDTO handler(ExeceptionNotFound ex){
        return new ExceptionDTO(
                ex.getMessage()
        );

    }
}
