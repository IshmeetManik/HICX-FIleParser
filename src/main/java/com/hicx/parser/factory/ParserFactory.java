package com.hicx.parser.factory;

import com.hicx.parser.fileParser.FileParser;
import com.hicx.parser.fileParser.impl.TextFileParser;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.util.logging.Logger;

public class ParserFactory {
    private static final Logger LOGGER = Logger.getLogger(ParserFactory.class.getName());
    public FileParser getParser(File file){
        LOGGER.info("getParser for File"+file.getPath());
        String fileExtension=FilenameUtils.getExtension(file.getPath());
        LOGGER.info("getParser for File Extension "+fileExtension);
        if(fileExtension.equalsIgnoreCase("txt")){
            return new TextFileParser();
        }
        return null;
    }
}
