package com.myowntry.datahandler;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by box on 07.06.2014.
 */
public class UrlProcessing {

    protected String getPlainTextByUrl(String url){
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
