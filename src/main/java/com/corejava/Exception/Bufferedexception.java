package com.corejava.Exception;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
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
                total += Float.parseFloat(line);
            }
            log.info("Total is " + total);
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }


    }
}