package com.rafa.domain.enums;

public enum TypeOfProtein {
    PERU("Peru", 0D),
    CHICKEN("Frango", 0.33),
    MEAT("Carne", 0.66),
    VEGETABLE("Vegetal", 1D);

    private final String text;
    private final Double value;

    TypeOfProtein(String text, Double value) {
        this.text = text;
        this.value = value;
    }

    public static TypeOfProtein getTypeOfProtein(String text) {
        for (TypeOfProtein type : TypeOfProtein.values()) {
            if (type.text.equals(text)) return type;
        }
        return null;
    }

    public String getText() {
        return text;
    }

    public Double getValue() {
        return value;
    }
}
