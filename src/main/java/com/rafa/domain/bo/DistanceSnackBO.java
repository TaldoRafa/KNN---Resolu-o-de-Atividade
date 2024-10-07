package com.rafa.domain.bo;

public class DistanceSnackBO {
    private final SnackBO snackBO;
    private final double distance;

    public DistanceSnackBO(SnackBO snackBO, double distance) {
        this.snackBO = snackBO;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "DistanceSnackBO{" +
                "snackBO=" + snackBO +
                ", distance=" + distance +
                '}';
    }

    public SnackBO getSnack() {
        return snackBO;
    }

    public double getDistance() {
        return distance;
    }
}