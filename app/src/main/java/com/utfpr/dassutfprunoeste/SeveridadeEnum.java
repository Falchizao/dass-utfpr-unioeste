package com.utfpr.dassutfprunoeste;

public enum SeveridadeEnum {
    LEVE("leve"),
    MINIMO("minimo"),
    MODERADO("moderado"),
    GRAVE("grave"),
    MUITOGRAVE("muito grave");

    private String content;

    private SeveridadeEnum (String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
