package com.csc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheeseAnalyzer {
    private List<Cheese> cheeses;

    public CheeseAnalyzer(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    public void analyzeAndWriteResults(String outputFile) {
        int pasteurizedCount = 0, rawCount = 0;
        int organicHighMoistureCount = 0;
        Map<String, Integer> milkTypeCount = new HashMap<>();

        for (Cheese cheese : cheeses) {

            if ("Pasteurized".equalsIgnoreCase(cheese.getMilkTreatment())) {
                pasteurizedCount++;
            } else if ("Raw Milk".equalsIgnoreCase(cheese.getMilkTreatment())) {
                rawCount++;
            }

            if (cheese.isOrganic() && cheese.getMoisturePercent() > 41.0) {
                organicHighMoistureCount++;
            }


            milkTypeCount.put(cheese.getMilkType(), milkTypeCount.getOrDefault(cheese.getMilkType(), 0) + 1);
        }


        String mostCommonMilkType = milkTypeCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");


        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Number of cheeses using pasteurized milk: " + pasteurizedCount + "\n");
            writer.write("Number of cheeses using raw milk: " + rawCount + "\n");
            writer.write("Number of organic cheeses with moisture > 41.0%: " + organicHighMoistureCount + "\n");
            writer.write("Most common milk type used in Canadian cheeses: " + mostCommonMilkType + "\n");
            System.out.println("Results successfully written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
