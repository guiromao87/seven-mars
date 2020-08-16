package com.guiromao.sevenmars.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlateauErrorValidationAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PlateauOutsideLimitException.class)
    public ErrorDto handleOutsidePlateauLimitError(PlateauOutsideLimitException ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PlateauUnregisteredLimitException.class)
    public ErrorDto handleUnregisteredPlateauLimitError(PlateauUnregisteredLimitException ex) {
        return new ErrorDto(ex.getMessage());
    }
}
