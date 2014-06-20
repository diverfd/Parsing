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

        UrlProcessing iProcessing = new UrlProcessing();
        String plainText = iProcessing.getPlainTextByUrl(url);

        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> counter = wordCounter.countWords(plainText);

        WordCounterResultSorter resultSorter = new WordCounterResultSorter();
        List<Map.Entry<String, Integer>> list = resultSorter.sortWords(counter);

//        Output output = new Output();
//        output.writeWordsToFile(list, resultFile);

        TestH2 testH2 = new TestH2();
        WordFilter wordFilter = new WordFilter();
        String parsedUrl = wordFilter.parseUrlForDb(url);
        testH2.writeToH2db(list, parsedUrl);
    }
}
