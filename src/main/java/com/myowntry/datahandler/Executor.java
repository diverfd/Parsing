package com.myowntry.datahandler;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by box on 07.06.2014.
 */
public class Executor {


    public static void main(String[] args) {
        final String URL1 = "docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html";
        final String URL2 = "lan.ua";
        final String URL3 = "bbc.com";
        final Executor e = new Executor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                e.runHtmlToPlain(URL1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                e.runHtmlToPlain(URL2);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                e.runHtmlToPlain(URL3);
            }
        });
        t1.start();
        t2.start();
        t3.start();

//        e.runHtmlToPlain();
    }



    protected void runHtmlToPlain(String url){
//        Input input = new Input();
//        String url = input.dataIn();

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
