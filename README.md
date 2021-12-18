
# File Parser

This File parser is written in JAVA 8 version and is used to false 
text file currently. But, it can be easily be enhanced using the 
Abstact class implementation and factory design pattern used .

We have used Watch Service in java.nio package to track of any new file 
being created in the folder we need to manage .

The comman line argument need to be the path we need to 
keep track and poll for any few file to be processed.


Command line Argument Example:


java com.hicx.parser.HICXFIleParser /Users/ishmeetsingh/Documents/Personal/Files

Here, the command line argument "/Users/ishmeetsingh/Documents/Personal/Files" is the path we
are polling for any new file , which if found will  trigger a file hadnle which 
in turn , using the file extension and ParserFactory class ,creates the appropriate 
parser.

# HICXFIleParser
It is main public class , which will trigger the FileWatcher thread which will poll the folder location passed to the class as command line argument

#FileWatcher
Creates a watch service for any new file creating at the folder location and will run a thread for continously polling the folder

#FileHandlerImpl
It is the class which will handle the file once a new file is detected int the folder location




