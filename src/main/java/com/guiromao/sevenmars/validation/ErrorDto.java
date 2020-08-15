package com.guiromao.sevenmars.validation;

public class ErrorDto {
    private String message;

    public ErrorDto(String mesage) {
        this.message = mesage;
    }

    public String getMessage() { return message; }
}
