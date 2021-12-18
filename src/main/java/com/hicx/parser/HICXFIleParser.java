package com.hicx.parser;

import com.hicx.parser.fileUtils.FileHandler;
import com.hicx.parser.fileUtils.impl.FileHandlerImpl;
import com.hicx.parser.fileUtils.FileWatcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;

public class HICXFIleParser {
    static void usage() {
        System.err.println("usage: java HICXFIleParser dir");
        System.exit(-1);
    }

    public static void main(String[]args){
        System.out.println("Inside Main"+args.length);
        for(String s:args){
            System.out.println("Inside Main"+s);
        }
        if (args.length == 0 || args.length > 1)
        {usage();
        }
        FileHandler fileHandlerTest = new FileHandlerImpl();
        //String path="/Users/ishmeetsingh/Documents/Personal/HICX/src/FilesToParse";
        File dir = new File(args[0]);
        Path myDir= dir.toPath();

        FileWatcher fileWatcher = null;
        try {
            fileWatcher = new FileWatcher(myDir, fileHandlerTest,false, StandardWatchEventKinds.ENTRY_CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread watcherThread = new Thread(fileWatcher);
        watcherThread.start();
    }
}
