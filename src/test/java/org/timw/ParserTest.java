package org.timw;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    private Parser testSubject;

    @Before
    public void before() {
        this.testSubject = new Parser();
    }

    @Test
    public void parse_src() throws Exception {
        final String line = "<script src=\"/static.chartbeat.com/js/chartbeat_mab.js\"></script>";
        final String expected = "/static.chartbeat.com/js/chartbeat_mab.js";

        final String actual = this.testSubject.parseSrc(line);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void parse_domain_http() {
        final String url = "http://news.bbc.co.uk";
        final String expected = "news.bbc.co.uk";
        final String actual = this.testSubject.stripProtocol(url);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void parse_domain_http_with_slash() {
        final String url = "http://news.bbc.co.uk/";
        final String expected = "news.bbc.co.uk";
        final String actual = this.testSubject.stripProtocol(url);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void parse_domain_https() {
        final String url = "https://news.bbc.co.uk";
        final String expected = "news.bbc.co.uk";
        final String actual = this.testSubject.stripProtocol(url);
        assertThat(actual).isEqualTo(expected);
    }


}