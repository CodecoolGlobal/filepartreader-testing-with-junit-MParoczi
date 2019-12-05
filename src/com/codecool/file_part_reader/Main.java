package com.codecool.file_part_reader;

public class Main {

    public static void main(String[] args) {
        String pathToFile = "C:\\Users\\Márk\\Desktop\\Iskola\\Codecool\\3. - OOP\\5TH SI Week\\FilePartReader testing with JUnit\\src\\com\\codecool\\file_part_reader\\input.txt";

        FilePartReader reader = new FilePartReader(pathToFile, 1, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

        System.out.println(reader.read());
        System.out.println(reader.readLines());
        System.out.println(analyzer.getWordsOrderedAlphabetically().toString());
        System.out.println(analyzer.getWordsContainingSubstring("app").toString());
        System.out.println(analyzer.getStringsWhichPalindromes());
    }
}
