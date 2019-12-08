package com.codecool.file_part_reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private String pathToFile = "C:\\Users\\Márk\\Desktop\\Iskola\\Codecool\\3. - OOP\\5TH SI Week\\FilePartReader testing with JUnit\\src\\com\\codecool\\file_part_reader\\input.txt";
    private FilePartReader reader = new FilePartReader(pathToFile, 1, 5);

}