package com.rafa.domain.enums;

public enum TypeOfSauce {
    SWEET_ONION("Cebola Agridoce ", 0D),
    CHIPOTLE("Chipotle ", 0.165),
    BARBECUE("Barbecue ", 0.33),
    PARMESAN("Parmesão", 0.495),
    SEASONED_MAYONNAISE("Maionese Temperada", 0.66),
    MUSTARD_AND_HONEY("Mostarda e Mel", 0.825),
    SUPREME("Supreme", 1D);

    private final String text;
    private final Double value;

    TypeOfSauce(String text, Double value) {
        this.text = text;
        this.value = value;
    }

    public static TypeOfSauce getTypeOfSauce(String text) {
        for (TypeOfSauce typeOfSauce : TypeOfSauce.values()) {
            if (typeOfSauce.text.equals(text)) return typeOfSauce;
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
