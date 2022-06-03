package com.corejava.Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.BaseLogger.Logger.commmonLogger;

public class Bufferedexception {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        float total = 0.0f;
        try {
            //reader = new BufferedReader(new FileReader("C:\\JavaWorkspace\\StreamPipeline\\images\\Numbers.txt"));
            FileReader file = new FileReader("C:\\JavaWorkspace\\StreamPipeline\\FileReader\\Numbers.txt");
            reader = new BufferedReader(file);

//			  while((line = reader.readLine()) != null)
//			  {
//				  total += Float.valueOf(line); 
//			  }

            for (String line = null; (line = reader.readLine()) != null; ) {
                total += Float.valueOf(line);
            }
            commmonLogger.info("Total is " + total);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            commmonLogger.info(e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            reader.close();
        }


    }
}