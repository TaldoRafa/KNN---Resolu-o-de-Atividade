package com.rafa;

import com.rafa.domain.bo.DistanceSnackBO;
import com.rafa.domain.bo.SnackBO;
import com.rafa.domain.enums.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final KNN KNN_ = new KNN();

    public static void main(String[] args) {
        System.out.println("| ------------------------------------------ |");
        System.out.println("| Algoritimo KNN - K Vizinhos mais Proximos  |");
        System.out.println("| Feito por: Rafael Roani Gonçalves          |");
        System.out.println("| ------------------------------------------ |\n");

        List<SnackBO> listSnackBOS = getListSnacks();

        SnackBO snackToFindKNeighbors = listSnackBOS.stream()
                .filter(snackBO -> snackBO.getTypeOfProtein() == null)
                .toList()
                .getFirst();

        List<SnackBO> snackBOS = listSnackBOS.stream()
                .filter(snackBO -> snackBO.getTypeOfProtein() != null)
                .toList();

        System.out.println("| Lanche a ser comparado: ");
        System.out.println("| " + snackToFindKNeighbors);
        System.out.println("| ------------------------------------------ |\n");

        List<DistanceSnackBO> distances = KNN_.getDistances(snackBOS, snackToFindKNeighbors);
        System.out.println("| Distancis dos Lanches: ");
        distances.forEach(distanceSnackBO -> {
            System.out.println("| Distancia: " + distanceSnackBO.getDistance() + " - " + distanceSnackBO.getSnack());
        });
        System.out.println("| ------------------------------------------ |\n");

        List<SnackBO> nearestNeighborsK01 = KNN_.findNearestNeighbors(snackBOS, snackToFindKNeighbors, 1);
        TypeOfProtein typeOfProteinK1 = KNN_.predictProtein(nearestNeighborsK01);

        List<SnackBO> nearestNeighborsK03 = KNN_.findNearestNeighbors(snackBOS, snackToFindKNeighbors, 3);
        TypeOfProtein typeOfProteinK3 = KNN_.predictProtein(nearestNeighborsK03);

        List<SnackBO> nearestNeighborsK05 = KNN_.findNearestNeighbors(snackBOS, snackToFindKNeighbors, 5);
        TypeOfProtein typeOfProteinK5 = KNN_.predictProtein(nearestNeighborsK05);

        System.out.println("| Resultado da proteina de acordo com cada K |");
        System.out.println("| K1: " + typeOfProteinK1.getText());
        System.out.println("| K3: " + typeOfProteinK3.getText());
        System.out.println("| K5: " + typeOfProteinK5.getText());
    }

    private static List<SnackBO> getListSnacks() {
        String path = "documentsxlsx/Lanches.xlsx";

        try (FileInputStream fileExcel = new FileInputStream(path);
             XSSFWorkbook sheets = new XSSFWorkbook(fileExcel);) {

            XSSFSheet sheet = sheets.getSheetAt(0);

            List<SnackBO> snackBOS = new ArrayList<>();
            for (Row linha : sheet) {
                if (linha.getRowNum() == 0) continue;
                if (linha.getRowNum() >= 17) continue;

                SnackBO snackBO = new SnackBO();
                linha.forEach(cell -> {
                    String cellValue = cell.getStringCellValue();
                    switch (cell.getColumnIndex()) {
                        case 0 -> snackBO.setTypeOfBread(TypeOfBread.getTypeOfBread(cellValue));
                        case 1 -> snackBO.setTypeOfCheese(TypeOfCheese.getTypeOfCheese(cellValue));
                        case 2 -> snackBO.setVegetables(Vegetables.getVegetables(cellValue));
                        case 3 -> snackBO.setTypeOfSauce(TypeOfSauce.getTypeOfSauce(cellValue));
                        case 4 -> snackBO.setTypeOfProtein(TypeOfProtein.getTypeOfProtein(cellValue));
                    }
                });
                snackBOS.add(snackBO);
            }
            return snackBOS;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
