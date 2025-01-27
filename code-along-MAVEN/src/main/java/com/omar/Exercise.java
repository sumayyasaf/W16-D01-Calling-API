package com.omar;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class Exercise {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Import library
//        if (checksum()) {
//            System.out.println("Successfully imported the Apache Commons IO library");
//        } else {
//            System.out.println("Wrong version of the library");
//        }

        // Working with Streams
//        readWebPage("https://digitalcareerinstitute.org/");

        // Working with files
        readFile("src/main/resources/LoremIpsum.txt");
        copyFile("src/main/resources/LoremIpsum.txt");

        // Find files with extension .java in other project
        findJavaFiles("./");
    }


//    private static boolean checksum() throws IOException {
//        // TODO: Add your code here
//
//        return checksum == 2449403980L;
//    }

    private static void readWebPage(String url) throws IOException {
        System.out.println("\n\nReading " + url);
        InputStream in = new URL(url).openStream();

        System.out.println(IOUtils.toString(in));

        // TODO: Add your code here
    }

    private static void readFile(String fileName) throws IOException {
        System.out.println("\n\nReading LoremIpsum.txt:");
        File sourceFile = new File(fileName);
        System.out.println(FileUtils.readFileToString(sourceFile));
        // TODO: Add your code here
    }

    private static void copyFile(String fileName) throws IOException, InterruptedException {
        System.out.println("\n\nCreating a copy of LoremIpsum.txt in " + FileUtils.getTempDirectory());
        // TODO: Add your code here

        File sourceFile = new File(fileName);
        File destinationFile = new File("src/main/resources/loremCopy.txt");
        FileUtils.copyFile(sourceFile,destinationFile);

        Thread.sleep(1500);

        FileUtils.forceDelete(destinationFile);

        // TODO: Add your code here
    }

    private static void findJavaFiles(String relativePath) {
        System.out.println("\n\nListing all java files in directory " + relativePath);
    }
}
