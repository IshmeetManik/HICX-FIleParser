package com.hicx.parser.fileParser;

public abstract class AbstractFileParser  implements  FileParser{

    @Override
    public void parseFile(String filePath) {
        parseFileContent(filePath);
        publishAnalysis(filePath);
    }
    public abstract void parseFileContent(String filePtah);
    public  void publishAnalysis(String filePtah){
        numberOfWords();
        numberOfDots();
        mostUsedWord();
    }
    public abstract void numberOfWords();
    public abstract void numberOfDots();
    public abstract void mostUsedWord();

}
