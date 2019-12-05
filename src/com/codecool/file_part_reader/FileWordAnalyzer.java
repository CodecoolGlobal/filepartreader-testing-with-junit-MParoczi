package com.codecool.file_part_reader;

import java.util.*;

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

    public List<String> getStringsWhichPalindromes () {
        Set<String> content = new HashSet<>(this.getWordsOrderedAlphabetically());
        Set<String> reversedWords = new HashSet<>();
        Set<String> intersectSet = new HashSet<>(content);

        for (String word : content) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(word);
            stringBuilder = stringBuilder.reverse();
            reversedWords.add(stringBuilder.toString());
        }
        intersectSet.retainAll(reversedWords);

        return new ArrayList<>(intersectSet);
    }
}
