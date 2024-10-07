package com.rafa;

import com.rafa.domain.bo.DistanceSnackBO;
import com.rafa.domain.bo.SnackBO;
import com.rafa.domain.enums.TypeOfProtein;

import java.util.*;

public class KNN {
    public TypeOfProtein predictProtein(List<SnackBO> nearestNeighbors) {
        Map<TypeOfProtein, Integer> counts = new HashMap<>();

        for (SnackBO snackBO : nearestNeighbors) {
            TypeOfProtein protein = snackBO.getTypeOfProtein();
            if (protein != null) {
                counts.put(protein, counts.getOrDefault(protein, 0) + 1);
            }
        }

        return counts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<SnackBO> findNearestNeighbors(List<SnackBO> snackBOS, SnackBO unknownSnackBO, int k) {
        List<DistanceSnackBO> distances = getDistances(snackBOS, unknownSnackBO);

        List<SnackBO> nearestNeighbors = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            nearestNeighbors.add(distances.get(i).getSnack());
        }
        return nearestNeighbors;
    }

    public List<DistanceSnackBO> getDistances(List<SnackBO> snackBOS, SnackBO unknownSnackBO) {
        List<DistanceSnackBO> distances = new ArrayList<>();

        for (SnackBO snackBO : snackBOS) {
            double distance = calculateDistance(snackBO, unknownSnackBO);
            distances.add(new DistanceSnackBO(snackBO, distance));
        }

        distances.sort(Comparator.comparingDouble(DistanceSnackBO::getDistance));

        return distances;
    }

    public double calculateDistance(SnackBO snackBO1, SnackBO snackBO2) {
        double distance = 0;

        if (snackBO1.getTypeOfBread() != null && snackBO2.getTypeOfBread() != null) {
            distance += Math.sqrt(
                    Math.pow(snackBO1.getTypeOfBread().getValue() - snackBO2.getTypeOfBread().getValue(), 2)
            );
        }

        if (snackBO1.getTypeOfCheese() != null && snackBO2.getTypeOfCheese() != null) {
            distance += Math.sqrt(
                    Math.pow(snackBO1.getTypeOfCheese().getValue() - snackBO2.getTypeOfCheese().getValue(), 2)
            );
        }

        if (snackBO1.getVegetables() != null && snackBO2.getVegetables() != null) {
            distance += Math.sqrt(
                    Math.pow(snackBO1.getVegetables().getValue() - snackBO2.getVegetables().getValue(), 2)
            );
        }

        if (snackBO1.getTypeOfSauce() != null && snackBO2.getTypeOfSauce() != null) {
            distance += Math.sqrt(
                    Math.pow(snackBO1.getTypeOfSauce().getValue() - snackBO2.getTypeOfSauce().getValue(), 2)
            );
        }

        if (snackBO1.getTypeOfProtein() != null && snackBO2.getTypeOfProtein() != null) {
            distance += Math.sqrt(
                    Math.pow(snackBO1.getTypeOfProtein().getValue() - snackBO2.getTypeOfProtein().getValue(), 2)
            );
        }

        return distance;
    }
}
