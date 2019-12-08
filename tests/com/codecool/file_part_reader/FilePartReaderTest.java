package com.codecool.file_part_reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private String pathToFile = "C:\\Users\\Márk\\Desktop\\Iskola\\Codecool\\3. - OOP\\5TH SI Week\\FilePartReader testing with JUnit\\src\\com\\codecool\\file_part_reader\\input.txt";

    @Test
    @DisplayName("Test the FilePartReader class' constructor")
    @Tag("constructor")
    void testReaderIsNotNull() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 5);
        assertNotNull(reader);
    }

    @Test
    @DisplayName("Test setup against invalid input (fromLine parameter less than 1")
    @Tag("setup")
    void testSetupFromLineIfLessThanOne() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 5);
        assertThrows(IllegalArgumentException.class, () -> reader.setup(pathToFile, 0, 1));
    }

    @Test
    @DisplayName("Test setup against invalid input (toLine is less than fromLine)")
    @Tag("setup")
    void testSetupToLineIsLessThanFromLine() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 5);
        assertThrows(IllegalArgumentException.class, () -> reader.setup(pathToFile, 5, 1));
    }

    @Test
    @DisplayName("Test setup against invalid argument (display the right error message)")
    @Tag("setup")
    void testSetupIfDisplayTheRightErrorMessage() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reader.setup(pathToFile, 5, 1));
        assertEquals("Invalid argument", exception.getMessage());
    }

    @Test
    @DisplayName("Test read method if it returns the right string")
    @Tag("read")
    void testReadIfReturnsTheRightString() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 5);
        assertEquals("Apple\nPear\nStrawberry\nBanana\nChocolate with white cream", reader.read());
    }

    @Test
    @DisplayName("Test read method if it throws NoSuchFileException in case of non existing file")
    @Tag("read")
    void testReadIfThrowsIOException() {
        FilePartReader reader = new FilePartReader("Non existing file", 1, 5);
        assertEquals("There is no such file", reader.read());
    }

    @Test
    @DisplayName("Test readLines method if it returns the right string")
    @Tag("readLines")
    void testReadLinesIfItReturnsTheRightString() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 3);
        assertEquals("Apple\nPear\nStrawberry", reader.readLines());
    }

    @Test
    @DisplayName("Test readLines method if it throws the right exception at invalid argument")
    @Tag("readLines")
    void testReadLinesIfItReturnsException() {
        FilePartReader reader = new FilePartReader(pathToFile, 1, 100);
        assertThrows(IllegalArgumentException.class, reader::readLines);
    }
}