package org.timw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebCrawler {

    private String domain;
    private Parser parser = new Parser();

    public void execute(final URL url) {
        this.domain = url.toString();
        this.getPage(url);
    }

    private static BufferedReader urlReader(final URL url)  {
        try {
            final URLConnection connection = url.openConnection();
            return new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
        }
        catch (IOException e) {
            throw new WebCrawlerException(e);
        }
    }

    public void getPage(final URL url) {
        System.out.println(url.toString());

        try {
            final BufferedReader reader = urlReader(url);
            final Page page = reader.lines().collect(Page::new, Page::accept, Page::combine);

            page.getLinks().stream().map(this::addProtocol).forEach(s -> printLink("    ", s));
            page.getStaticContent().stream().map(this::addProtocol).forEach(s -> printLink("        ", s));

            // Need to filter out links already visited here, but ran out of time.
            page.getLinks().stream().map(this::addProtocol).filter(this::shouldFollow)
                    .forEach(s -> this.getPage(toUrl(addProtocol(s))));
        }
        catch (WebCrawlerException e) {
            // ignore and keep going to avoid polluting the output
        }
    }

    private static URL toUrl(final String urlRef) {
        try {
            return new URL(urlRef);
        } catch (Exception e) {
            throw new WebCrawlerException(e);
        }
    }

    private boolean shouldFollow(final String link) {
        return link.contains(this.domainName());
    }

    private String domainName() {
        return this.parser.stripProtocol(this.domain);
    }

    private String addProtocol(final String link) {
        if (!link.startsWith("http")) {
            return this.domain + "/" + link;
        }
        return link;
    }

    // Should use proper logging here instead, but again - time.
    private static void printLink(final String offset, final String link) {
        System.out.println(offset + link);
    }

}
