package com.myowntry.datahandler;

import java.util.Scanner;

/**
 * Created by box on 07.06.2014.
 */
public class Input {

    protected String dataIn(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter URL http://:");
        String url ="http://" + in.nextLine(); //todo: add URL checking

        return url;

    }
}
