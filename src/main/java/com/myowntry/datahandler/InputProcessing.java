package com.myowntry.datahandler;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by box on 07.06.2014.
 */
public class InputProcessing {

    protected String processTheUrl(String url){
        Document html= null;
        try {
            html = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String plainText = new HtmlToPlainText().getPlainText(Jsoup.parse(String.valueOf(html)));

        return plainText;
    }
}
