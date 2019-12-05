package com.codecool.file_part_reader;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }
}
