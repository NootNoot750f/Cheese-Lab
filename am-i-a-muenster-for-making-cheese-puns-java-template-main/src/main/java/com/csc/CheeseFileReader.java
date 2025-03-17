package com.csc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheeseFileReader {
    public static List<Cheese> readCheeseData(String filePath) {
        List<Cheese> cheeses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); 
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 10) continue;

                String milkTreatment = data[9].trim();
                boolean isOrganic = data[6].trim().equals("1"); 
                double moisturePercent = data[3].isEmpty() ? -1 : Double.parseDouble(data[3]);
                String milkType = data[8].trim();

                cheeses.add(new Cheese(milkTreatment, isOrganic, moisturePercent, milkType));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return cheeses;
    }
}
