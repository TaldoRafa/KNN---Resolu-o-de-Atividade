package com.rafa.domain.enums;

public enum Vegetables {
    OLIVES("Azeitonas", 0D),
    PICKLES("Picles", 0.11),
    CUCUMBERS("Pepinos", 0.22),
    PEPPER("Pimentão", 0.33),
    LETTUCE("Alface", 0.44),
    PURPLE_ONION("Cebola Roxa", 0.55),
    TOMATO("Tomate", 0.66),
    ARUGULA("Rúcula", 0.77),
    GRATED_CARROT("Cenoura Ralada", 0.88),
    VINEGARET("Vinagrete", 1D);

    private final String text;
    private final Double value;

    Vegetables(String text, Double value) {
        this.text = text;
        this.value = value;
    }

    public static Vegetables getVegetables(String text) {
        for (Vegetables v : Vegetables.values()) {
            if (text.equalsIgnoreCase(v.getText())) return v;
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
