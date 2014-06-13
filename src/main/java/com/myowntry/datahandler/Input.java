package com.myowntry.datahandler;

import java.util.Scanner;

/**
 * Created by box on 07.06.2014.
 */
public class Input {

    public String dataIn(){
        Scanner in = new Scanner(System.in);
        String http = "http://";
        String url;
        do{
            System.out.print("Enter URL : http://");
            url = in.nextLine();
        } while(url == null || url.length() == 0);
        url = http + url;

        return url;

    }
}
