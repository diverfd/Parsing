package com.myowntry.datahandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * Created by box on 07.06.2014.
 */
public class Output {

    protected void writeWordsToFile(List<Map.Entry<String, Integer>> sortedWords, File wordsFilePath){
        Writer writer = null;
        try {
            writer = new FileWriter(wordsFilePath);
            for(Map.Entry<String, Integer> each : sortedWords){
                writer.write(String.valueOf(each) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
