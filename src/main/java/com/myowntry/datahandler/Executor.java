package com.myowntry.datahandler;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by box on 07.06.2014.
 */
public class Executor {
    private File resultFile;

    public static void main(String[] args) {
        Executor e = new Executor();
        String homePath = args[0];
        if (homePath == null) {
            throw new IllegalStateException("Путь к домашней директории не введен");
        }
        String resultFilePath = homePath + "Result.txt";
        e.resultFile = new File(resultFilePath);

        e.runHtmlToPlain();
    }



    protected void runHtmlToPlain(){
        Input input = new Input();
        String url = input.dataIn();

        InputProcessing iProcessing = new InputProcessing();
        String plainText = iProcessing.processTheUrl(url);

        DataProcessing dProcessing = new DataProcessing();
        Map<String, Integer> counter = dProcessing.wordsCounterByEachWord(plainText);
        List<Map.Entry<String, Integer>> list = dProcessing.sortWords(counter);

        Output output = new Output();
        output.writeWordsToFile(list, resultFile);
    }
}
