package com.codecool.file_part_reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) {
        this.setup(filePath, fromLine, toLine);
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (fromLine < 1 || toLine < fromLine) throw new IllegalArgumentException("Invalid argument");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read(){
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(this.filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
            contentBuilder.delete(contentBuilder.length() - 1, contentBuilder.length());
        } catch (IOException e) {
            return "There is no such file";
        }
        return contentBuilder.toString();
    }

    public String readLines() {
        String content = this.read();
        List<String> lines = new ArrayList<>(Arrays.asList(content.split("\n")));
        StringBuilder requiredContent = new StringBuilder();
        int INDEX_CORRECTION = 1;

        for (String line : lines.subList(this.fromLine - INDEX_CORRECTION, this.toLine - INDEX_CORRECTION)) {
            requiredContent.append(line).append("\n");
        }
        requiredContent.append(lines.get(this.toLine - INDEX_CORRECTION));

        return requiredContent.toString();
    }
}
