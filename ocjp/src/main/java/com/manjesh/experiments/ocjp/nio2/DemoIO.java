package com.manjesh.experiments.ocjp.nio2;

import java.io.*;
import java.util.*;

/**
 * Created by aadhya on 12/3/2016.
 */

//https://www.safaribooksonline.com/library/view/oracle-certified-professional/9781484218365/9781484218358_Ch09.xhtml

//Test Book
//https://www.safaribooksonline.com/library/view/oca-ocp/9781119363392/c14.xhtml


//TODO Writing to and Reading from Object Streams
public class DemoIO {

    private static final int EOF = -1;

    public static void main(String[] args) throws Exception {
        //readFromConsole();
        //readString();
        //redirectOutputStream();
        //rewrtiteConsole();
        //System.out.printf("%d %<x",17);
        //readFile();
        //readFileWithBuffer();
        //readFileWithScanner();
        //checkIfValidClassFile();
        //readWriteDataStream();
        readWriteObjectStreams();
    }

    private static void readWriteObjectStreams() {
        Map<String, String> presidentsOfUS = new HashMap<>();
        presidentsOfUS.put("Barack Obama", "2009 to --, Democratic Party, 56th term");
        presidentsOfUS.put("George W. Bush", "2001 to 2009, Republican Party, 54th and 55th terms");
        presidentsOfUS.put("Bill Clinton", "1993 to 2001, Democratic Party, 52nd and 53rd terms");
    }

    private static void readWriteDataStream() {

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("test.data"))) {
            for (int i = 0; i < 10; i++) {
                dos.writeByte(i);
                dos.writeShort(i);
                dos.writeInt(i);
                dos.writeLong(i);
                dos.writeFloat(i);
                dos.writeDouble(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("test.data"))) {
            for(int i = 0; i < 10; i++) {
                // %d is for printing byte, short, int or long
                // %f, %g, or %e is for printing float or double
                // %n is for printing newline
                System.out.printf("%d %d %d %d %g %g %n",
                        dis.readByte(),
                        dis.readShort(),
                        dis.readInt(),
                        dis.readLong(),
                        dis.readFloat(),
                        dis.readDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkIfValidClassFile() {

        try (FileInputStream fileInputStream = new FileInputStream("test2.class");
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(new FileOutputStream("test3.class"))
        ) {
            byte[] magicNumber = {(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};
            byte[] first4 = new byte[4];

            if (fileInputStream.read(first4) != -1) {
                if (Arrays.equals(first4, magicNumber)) {
                    print("Valid class File");
                    bufferedOutputStream.write(first4);
                }
                else
                    print("Not a class file");
            }

            while (true) {
                int val = 0;
                val = fileInputStream.read();
                if (val != -1) {
                    bufferedOutputStream.write((byte)val);
                } else
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readFileWithScanner() {

        try (Scanner scanner = new Scanner(new FileReader("log.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log2.txt"))) {

            Set<String> sortedWords = new TreeSet<>();
            scanner.useDelimiter("\\W");
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (null != word) {
                    sortedWords.add(word);
                    bufferedWriter.write(word);
                    bufferedWriter.newLine();
                }
            }
            sortedWords.forEach(DemoIO::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFileWithBuffer() {

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("log.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log1.txt"));
        ) {
            while (true) {
                int readChar = bufferedReader.read();
                if (readChar == -1)
                    break;
                System.out.print((char) readChar);
                bufferedWriter.write((char) readChar);
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    private static void readFile() throws Exception {
        FileReader fileReader = new FileReader("log.txt");
        int ch = 0;
        while (true) {
            ch = fileReader.read();
            System.out.print((char) ch);
            if (ch == EOF)
                break;
        }
    }

    private static void rewrtiteConsole() {
        // get the System console object
        Console console = System.console();
        if (console == null) {
            System.err.println("Cannot retrieve console object - " +
                    "are you running your application from an IDE? Exiting the application ... ");
            System.exit(-1); // terminate the application
        }
        // read a line and print it through printf
        console.printf(console.readLine());

    }

    private static void redirectOutputStream() throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream("log.txt");
        System.setOut(filePrintStream);
        System.setErr(filePrintStream);

        System.out.println("Hi Ganesh");
        System.err.println("Jai Ganesh");
    }

    private static void readString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());

        System.out.println("Enter data for scanner");
        Scanner scanner = new Scanner(inputStreamReader);
        System.out.println(scanner.next());

        System.out.println("Enter any key to exit");
        System.in.read();
    }

    private static void readFromConsole() {
        System.out.println("Type a character");
        int val = 0;
        try {
            val = System.in.read();
            if (val > 60)
                throw new Exception("Not allowed");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("You entered => " + Integer.toString(val));
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
