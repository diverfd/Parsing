package com.myowntry.datahandler;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.Scanner;

/**
 * Created by box on 07.06.2014.
 */
public class Input {

    public String dataIn(){
        String http = "http://";
        String url;
        Scanner in = new Scanner(System.in);
        UrlValidator urlValidator = new UrlValidator();
        do{
            System.out.print("Enter URL : http://");
            url = in.nextLine();
        } while(!urlValidator.isValid(http + url));
//    } while(url == null || url.length() == 0);
        url = http + url;

        return url;
    }
}
