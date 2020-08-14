package com.guiromao.sevenmars.validation;

public class ProbleErrorFormDto {
    private String field;
    private String message;

    public ProbleErrorFormDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() { return field; }

    public String getMessage() {
        return message;
    }
}
