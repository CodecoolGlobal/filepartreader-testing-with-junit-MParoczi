package com.codecool.file_part_reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        String content = reader.readLines();

        List<String> words = new ArrayList<>(Arrays.asList(content.replaceAll( "\\p{Punct}", "").toLowerCase().split("\\s+")));

        Collections.sort(words);

        return words;
    }

    public List<String> getWordsContainingSubstring (String subString ) {
        List<String> content = this.getWordsOrderedAlphabetically();
        List<String> result = new ArrayList<>();

        for (String word : content) {
            if (word.contains(subString)) {
                result.add(word);
            }
        }
        return result;
    }
}
