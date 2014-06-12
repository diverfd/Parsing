package com.myowntry.datahandler;

import java.util.regex.Pattern;

/**
 * Created by box on 12.06.2014.
 */
public class WordFilter {

    private static final Pattern NON_WORD_LETTER_PATTERN = Pattern.compile("[^a-zA-Z]");

    public String filterWord(String word){
        return NON_WORD_LETTER_PATTERN.matcher(word).replaceAll("");
    }
}
