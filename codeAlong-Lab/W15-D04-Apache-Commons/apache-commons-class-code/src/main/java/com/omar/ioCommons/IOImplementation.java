package com.omar.ioCommons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class IOImplementation {
    public static void main(String[] args) throws IOException {

//        readFromWebsite();

        File startingFile = new File("src/main/resources/kai.txt");
        File destinationFile = new File("src/main/resources/paul.txt");

//        Reading from a file
        System.out.println(FileUtils.readFileToString(startingFile));

//        copying a file
        FileUtils.copyFile(startingFile,destinationFile);


//        deleting a file
//        FileUtils.forceDelete(destinationFile);

        File projectDirectory = new File("src");

        System.out.println(FileUtils.listFiles(projectDirectory,new String[]{"txt"},true));


    }

    public static void readFromWebsite(){

        URL url;
        InputStream inputStream;
        try {
            url = new URL("https://www.facebook.com/");
            inputStream = url.openStream();
            System.out.println(IOUtils.toString(inputStream));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
