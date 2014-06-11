package com.ttu.roman.validator;

import java.util.Map;

public class ErrorMapHolder {

    private Map<String, String> errors;
    private Integer formIndex;

    public ErrorMapHolder(Map<String, String> errors, Integer formIndex) {
        this.errors = errors;
        this.formIndex = formIndex;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public Integer getFormIndex() {
        return formIndex;
    }
}
