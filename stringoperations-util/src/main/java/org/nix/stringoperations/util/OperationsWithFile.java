package org.nix.stringoperations.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OperationsWithFile {

    public static String ConvertFileToString() {

        String respath = "fishtext.txt";
        StringBuilder returnValue= new StringBuilder();
        InputStream in = OperationsWithFile.class.getClassLoader().getResourceAsStream(respath);
        try {
            if ( in == null ) {
                throw new Exception("resource not found: " + respath);
            }
            else {
                InputStreamReader inr = null;
                inr = new InputStreamReader(in, StandardCharsets.UTF_8);
                int len;
                char[] cbuf = new char[1024];
                for (; ; ) {
                    int rsz = inr.read(cbuf, 0, cbuf.length);
                    if (rsz < 0)
                        break;
                    returnValue.append(cbuf, 0, rsz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue.toString();
    }

    public static String ConvertFileToString(String fileName){
        return getAllStringFromFile(fileName);
    }

    private static String getAllStringFromFile(String fileName) {
        StringBuilder returnValue= new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String s;
            while((s = br.readLine()) != null) {
                returnValue.append(s).append("\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return returnValue.toString();
    }

    private static String getAllStringFromFile(File file) {
        StringBuilder returnValue= new StringBuilder();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader))
        {
            String s;
            while((s = br.readLine()) != null) {
                returnValue.append(s).append("\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return returnValue.toString();
    }
}
