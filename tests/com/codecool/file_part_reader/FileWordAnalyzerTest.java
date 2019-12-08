package com.codecool.file_part_reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private String pathToFile = "C:\\Users\\Márk\\Desktop\\Iskola\\Codecool\\3. - OOP\\5TH SI Week\\FilePartReader testing with JUnit\\src\\com\\codecool\\file_part_reader\\input.txt";
    private FilePartReader reader = new FilePartReader(pathToFile, 1, 5);

    @Test
    @DisplayName("Test Analyzer constructor")
    @Tag("constructor")
    void testAnalyzerConstructor() {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertNotNull(analyzer);
    }

    @Test
    @DisplayName("Test alphabetical ordering")
    @Tag("alphabetical")
    void testAlphabeticalOrdering() {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals("[apple, banana, chocolate, cream, pear, strawberry, white, with]", analyzer.getWordsOrderedAlphabetically().toString());
    }

    @Test
    @DisplayName("Test substring searching method")
    @Tag("substring")
    void testSubstringSearching() {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals("[apple, banana, chocolate, cream, pear, strawberry]", analyzer.getWordsContainingSubstring("a").toString());
    }
}