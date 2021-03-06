package com.hicx.parser.fileUtils;


import java.io.File;
import java.nio.file.WatchEvent;

/**
 * Generic FileHandler to be implemented
 * to perform any action after the file event is detected
 * @author Omkar Marathe
 * @since October 20,2018
 *
 */
public interface FileHandler {

    /**
     * Method is invoked post file event is detected
     * @param file
     * @param fileEvent
     * @throws InterruptedException
     */
    void handle(File file,WatchEvent.Kind<?> fileEvent) throws InterruptedException;

}