package com.guiromao.sevenmars.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlateauErrorValidationAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OutsidePlateauLimitException.class)
    public ErrorDto handleOutsidePlateauLimitError(OutsidePlateauLimitException ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnregisteredPlateauLimitException.class)
    public ErrorDto handleUnregisteredPlateauLimitError(UnregisteredPlateauLimitException ex) {
        return new ErrorDto(ex.getMessage());
    }
}
