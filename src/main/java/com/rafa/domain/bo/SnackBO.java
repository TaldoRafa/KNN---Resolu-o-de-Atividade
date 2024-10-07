package com.rafa.domain.bo;

import com.rafa.domain.enums.*;

import java.util.Objects;

public class SnackBO {
    private TypeOfBread typeOfBread;
    private TypeOfCheese typeOfCheese;
    private Vegetables vegetables;
    private TypeOfSauce typeOfSauce;
    private TypeOfProtein typeOfProtein;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnackBO snackBO)) return false;
        return getTypeOfBread() == snackBO.getTypeOfBread() &&
                getTypeOfCheese() == snackBO.getTypeOfCheese() &&
                getVegetables() == snackBO.getVegetables() &&
                getTypeOfSauce() == snackBO.getTypeOfSauce() &&
                getTypeOfProtein() == snackBO.getTypeOfProtein();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeOfBread(), getTypeOfCheese(), getVegetables(), getTypeOfSauce(), getTypeOfProtein());
    }

    @Override
    public String toString() {
        return "Snack{" +
                "typeOfBread=" + typeOfBread +
                ", typeOfCheese=" + typeOfCheese +
                ", vegetables=" + vegetables +
                ", typeOfSauce=" + typeOfSauce +
                ", typeOfProtein=" + typeOfProtein +
                '}';
    }

    public TypeOfBread getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(TypeOfBread typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public TypeOfCheese getTypeOfCheese() {
        return typeOfCheese;
    }

    public void setTypeOfCheese(TypeOfCheese typeOfCheese) {
        this.typeOfCheese = typeOfCheese;
    }

    public Vegetables getVegetables() {
        return vegetables;
    }

    public void setVegetables(Vegetables vegetables) {
        this.vegetables = vegetables;
    }

    public TypeOfSauce getTypeOfSauce() {
        return typeOfSauce;
    }

    public void setTypeOfSauce(TypeOfSauce typeOfSauce) {
        this.typeOfSauce = typeOfSauce;
    }

    public TypeOfProtein getTypeOfProtein() {
        return typeOfProtein;
    }

    public void setTypeOfProtein(TypeOfProtein typeOfProtein) {
        this.typeOfProtein = typeOfProtein;
    }
}
