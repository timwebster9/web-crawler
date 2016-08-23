package org.timw;

import java.net.MalformedURLException;
import java.net.URL;

public class AppMain {

    private static String DOMAIN;

    public static void main(final String[] args) {
        if (handleArgs(args)) {
            DOMAIN = args[0];
            run();
        }
    }

    private static void run() {
        try {
            final URL url= new URL(DOMAIN);
            final WebCrawler webCrawler = new WebCrawler();
            webCrawler.execute(url);
        } catch (MalformedURLException e) {
            System.out.println("Error launching application.  Is the URL correct: <" + DOMAIN + ">? You must provide the protocol (e.g. 'http://somedomain.com')");
        }
    }

    private static boolean handleArgs(final String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: AppMain <domain>");
            return false;
        }
        return true;
    }

}
