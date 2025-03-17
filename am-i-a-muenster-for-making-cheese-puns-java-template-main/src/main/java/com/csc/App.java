package com.csc;


import java.util.List;

public class App {
    public static void main(String[] args) {
        String inputFilePath = "F:\\nickh\\Documents\\1Harper College Files\\Spring 2025\\CSC 214\\Module 9\\Cheese-Lab\\cheese.data.csv";
        String outputFilePath = "F:\\nickh\\Documents\\1Harper College Files\\Spring 2025\\CSC 214\\Module 9\\Cheese-Lab\\output.txt";


        List<Cheese> cheeses = CheeseFileReader.readCheeseData(inputFilePath);


        CheeseAnalyzer analyzer = new CheeseAnalyzer(cheeses);
        analyzer.analyzeAndWriteResults(outputFilePath);
    }
}
