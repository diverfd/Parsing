package com.myowntry.datahandler;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by box on 07.06.2014.
 */
public class WordCounter {


    public Map<String, Integer> countWords(String plainText){
        WordFilter wordFilter = new WordFilter();
        Map<String, Integer> counter = new HashMap<String, Integer>();

        String[] str = plainText.split("\\s+");

        for (String eachWord : str) {
            String filteredWord = wordFilter.filterWord(eachWord);
            Integer foundValue = counter.get(filteredWord);
            if (foundValue == null) {
                counter.put(filteredWord, 1);
            } else {
                Integer newCounter = ++foundValue;
                counter.put(filteredWord, newCounter);
            }
        }
        counter.remove("");
        return counter;
    }



}
