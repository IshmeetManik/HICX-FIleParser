package com.hicx.parser.fileParser.impl;

import com.hicx.parser.fileParser.AbstractFileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class TextFileParser extends AbstractFileParser {
    private static final Logger LOGGER = Logger.getLogger(TextFileParser.class.getName());
    private String mostUsedWord=null;
    private int numberOfWords=0;
    private int numberOfDots=0;

    @Override
    public void parseFileContent(String filePtah) {
        LOGGER.info("parseFileContent");
        File file = new File(filePtah);
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line, word;
        StringTokenizer token;
        Map<String, Integer> wordCountMap = new HashMap<>();
        Map<Character, Integer> characterMap = new HashMap<>();
        int words = 0; //word count
        int lines = 0; //line count
        int chars = 0; //char count
        while (inputFile.hasNext())
        {
            lines++; //add one to line count
            line = inputFile.nextLine();
            token = new StringTokenizer(line, "([,\\s]+) ");
            while (token.hasMoreTokens())
            {
                words++; //add one word count
                word = token.nextToken();
                String key = word.toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                if (key.length() > 0) {
                    if (wordCountMap.get(key) == null) {
                        wordCountMap.put(key, 1);
                    } else {
                        int value = wordCountMap.get(key).intValue();
                        value++;
                        wordCountMap.put(key, value);
                    }
                }
                chars+= word.toLowerCase().length(); //add to char count
                char[] characters=word.toLowerCase().toCharArray();
                for(Character c:characters){
                    if (characterMap.get(c) == null) {
                        characterMap.put(c, 1);
                    } else {
                        int value = characterMap.get(c).intValue();
                        value++;
                        characterMap.put(c, value);
                    }
                }
            }
        }
        wordCountMap.get("insert");
        int numberOfDots=characterMap.get('.');
        int numberOfWords=words;
        String mostUsedWord=wordCountMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        setAnalytics(numberOfDots,numberOfWords,mostUsedWord);
    }

    @Override
    public void numberOfWords() {
        LOGGER.info("numberOfWords in file -"+numberOfWords);
    }

    @Override
    public void numberOfDots() {
        LOGGER.info("numberOfDots in file -"+numberOfDots);
    }

    @Override
    public void mostUsedWord() {
        LOGGER.info("mostUsedWord in file -"+mostUsedWord);
    }
    private void setAnalytics(int numberOfDots,int numberOfWords,String mostUsedWord){
        this.mostUsedWord=mostUsedWord;
        this.numberOfDots=numberOfDots;
        this.numberOfWords=numberOfWords;
    }
}
