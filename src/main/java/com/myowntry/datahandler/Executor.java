package com.myowntry.datahandler;

import java.util.List;
import java.util.Map;

/**
 * Created by box on 07.06.2014.
 */
public class Executor {
    final String URL1 = "docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html";
    final String URL2 = "lan.ua";
    final String URL3 = "bbc.com";

    public static void main(String[] args) {

        Executor e = new Executor();
        e.startThreads(e.URL1, e.URL2, e.URL3);

//        e.goingToCountWords();
    }

    private void startThreads(final String URL1, final String URL2, final String URL3) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                goingToCountWords(URL1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                goingToCountWords(URL2);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                goingToCountWords(URL3);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }


    protected void goingToCountWords(String url){
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

        H2dbLogic h2dbLogic = new H2dbLogic();
        WordFilter wordFilter = new WordFilter();
        String parsedUrl = wordFilter.parseUrlForDb(url);
        h2dbLogic.writeToH2db(list, parsedUrl);
    }
}
