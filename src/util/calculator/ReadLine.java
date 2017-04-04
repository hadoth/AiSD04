package util.calculator;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Karol Pokomeda on 2017-03-30.
 * Method handles readingof one line at a time from the source specified in the constructor
 */
public class ReadLine {
    private Scanner in;
    private String line;

    /**
     * @param {File} inputFile txt file containing equations, one equation for each row
     * @throws FileNotFoundException when input file is not detected
     */
    public ReadLine(File inputFile) throws FileNotFoundException {
        in = new Scanner(inputFile);
    }

    /**
     * @param {InputStream} source, e.g System.in, file stream, etc.
     */
    public ReadLine(InputStream source){
        in = new Scanner(source);
    }

    /**
     * Method prompts command to provide input equation, reads new line provided by user and returns it as a string
     * @return
     */
    public String read(){
        System.out.println("\nEnter the equation:");
        System.out.println();
        this.line = this.in.nextLine();
        return this.line;
    }
}
