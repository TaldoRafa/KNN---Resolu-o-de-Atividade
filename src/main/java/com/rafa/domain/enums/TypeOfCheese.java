package com.rafa.domain.enums;

public enum TypeOfCheese {
    CHEDDAR("Cheddar", 0D),
    SWISS("Suíço", 0.5),
    MOZZARELLA("Mussarela", 1D);

    private final String text;
    private final Double value;

    TypeOfCheese(String text, Double value) {
        this.text = text;
        this.value = value;
    }

    public static TypeOfCheese getTypeOfCheese(String text) {
        for (TypeOfCheese type : TypeOfCheese.values()) {
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
