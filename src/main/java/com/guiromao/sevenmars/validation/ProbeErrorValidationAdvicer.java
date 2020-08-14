package com.guiromao.sevenmars.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ProbeErrorValidationAdvicer {

    @Autowired
    private MessageSource messageSource;

    @Value("${proble.error.field}")
    private String field;

    @Value("${proble.error.message}")
    private String message;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ProbleErrorFormDto> handlePositionError(MethodArgumentNotValidException ex) {
        List<ProbleErrorFormDto> probeErrorsDto = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> {
            probeErrorsDto.add(
                    new ProbleErrorFormDto(e.getField(), messageSource.getMessage(e, LocaleContextHolder.getLocale())));
        });

        return probeErrorsDto;
    }


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProbleErrorFormDto handleDirectionError(HttpMessageNotReadableException ex) {
        return new ProbleErrorFormDto(field, message);
    }

}
