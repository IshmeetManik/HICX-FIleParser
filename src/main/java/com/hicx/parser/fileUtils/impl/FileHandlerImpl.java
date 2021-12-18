package com.hicx.parser.fileUtils.impl;

import com.hicx.parser.factory.ParserFactory;
import com.hicx.parser.fileParser.FileParser;
import com.hicx.parser.fileUtils.FileHandler;

import java.io.File;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandlerImpl implements FileHandler {

    private static final Logger LOGGER = Logger.getLogger(FileHandlerImpl.class.getName());

    /*
     * This implemented method will delete the file
     *
     * @see com.io.util.FileHandler#handle(java.io.File,
     * java.nio.file.WatchEvent.Kind)
     */
     @Override
    public void handle(File file, WatchEvent.Kind<?> fileEvent) {
        LOGGER.log(Level.INFO,"Handler is triggered for file {0}",file.getPath());
        if(fileEvent == StandardWatchEventKinds.ENTRY_CREATE) {
            try {
                ParserFactory factory=new ParserFactory();
                FileParser parser=factory.getParser(file);
                if(parser!=null) {
                    parser.parseFile(file.getPath());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}