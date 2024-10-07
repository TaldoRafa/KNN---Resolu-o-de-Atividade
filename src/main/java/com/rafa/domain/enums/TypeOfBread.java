package com.rafa.domain.enums;

public enum TypeOfBread {
    ITALIAN("Italiano", 0D),
    SIMPLE("Simples", 0.25),
    CHEESES_3("3 Queijos", 0.5),
    SAVORY_GRANOLA("Granola Salgada", 0.75),
    GRAINS_9("9 grãos", 1D);

    private final String text;
    private final Double value;

    TypeOfBread(String text, Double value) {
        this.text = text;
        this.value = value;
    }

    public static TypeOfBread getTypeOfBread(String text) {
        for (TypeOfBread bread : TypeOfBread.values()) {
            if (bread.text.equals(text)) return bread;
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
