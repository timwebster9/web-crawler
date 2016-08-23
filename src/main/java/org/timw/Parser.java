package org.timw;

public class Parser {

    public  String parseHref(final String line) {
        int start = line.indexOf("href=") + 5;
        int end = line.indexOf('"', start + 1);
        return line.substring(start + 1, end);
    }

    public String parseSrc(final String line) {
        int start = line.indexOf("src=") + 4;
        int end = line.indexOf('"', start + 1);
        return line.substring(start + 1, end);
    }

    public String stripProtocol(final String domain) {
        // cheap guess at where http:// roughly is...
        final int start = domain.indexOf(':') + 3;
        if (domain.endsWith("/")) {
            final int end = domain.indexOf('/', start);
            return domain.substring(start, end);
        }
        return domain.substring(start);
    }
}
