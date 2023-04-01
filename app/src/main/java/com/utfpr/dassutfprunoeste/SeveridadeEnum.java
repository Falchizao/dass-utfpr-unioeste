package com.utfpr.dassutfprunoeste;

public enum SeveridadeEnum {
    LEVE("Normal"),
    MINIMO("Minimo"),
    MODERADO("Moderado"),
    GRAVE("Grave"),
    MUITOGRAVE("Muito grave");

    private String content;

    private SeveridadeEnum (String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
