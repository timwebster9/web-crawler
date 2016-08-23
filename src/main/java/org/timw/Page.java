package org.timw;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private List<String> links = new ArrayList<>();
    private List<String> staticContent = new ArrayList<>();
    private Parser parser = new Parser();

    public void accept(final String line) {
        if (hasLink(line)) {
            this.links.add(this.parser.parseHref(line));
        }
        if (hasContent(line)) {
            this.staticContent.add(this.parser.parseSrc(line));
        }
    }

    public void combine(final Page page) {
        this.links.addAll(page.getLinks());
        this.staticContent.addAll(page.getStaticContent());
    }

    public List<String> getLinks() {
        return links;
    }

    public List<String> getStaticContent() {
        return staticContent;
    }

    // get links and leave out mailto: links
    private static boolean hasLink(final String line) {
        return line.contains("href") && !line.contains("mailto:");
    }

    private static boolean hasContent(final String line) {
        return line.contains("src=");
    }
}
