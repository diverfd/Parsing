package com.myowntry.datahandler;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by box on 07.06.2014.
 */
public class DataProcessing {
    private static final Pattern PATTERN = Pattern.compile("[^a-zA-Z]");

    private String wordFilter(String word){
        return PATTERN.matcher(word).replaceAll("");
    }

    protected Map<String, Integer> wordsCounterByEachWord(String plainText){
        Map<String, Integer> counter = new HashMap<String, Integer>();

        String[] str = plainText.split("\\s+");

        for (String eachWord : str) {
            String filteredWord = wordFilter(eachWord);
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

    protected List<Map.Entry<String, Integer>> sortWords(Map counter){
        Set<Map.Entry<String, Integer>> set = counter.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                boolean isMapDate01Empty = (o1.getValue() == null || o1.getValue().equals(""));
                boolean isMapDate02Empty = (o2.getValue() == null || o2.getValue().equals(""));

                if (isMapDate01Empty && isMapDate02Empty)
                    return 0;
                // at least one of them is not empty
                if (isMapDate01Empty)
                    return -1;
                if (isMapDate02Empty)
                    return 1;
                //none of them is empty
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }
}
