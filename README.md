# web-crawler

## Building
### Requirements
* Apache Maven
* JDK 8

To build, from the project root directory run:
    
    mvn clean package
    

## Running

To run the application, from the project root directory:
    
    java -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain <URL>
    
where <URL> is a URL of your choice.  You must include a protocol prefix (e.g. http://mydomain.com)

e.g.
    
    java -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain http://news.bbc.co.uk
    
### Running with a Proxy Server

If you are behind a proxy server, include the following system properties with appropriate values:

    
    java -Dhttp.proxyHost=<proxy hostname> -Dhttp.proxyPort=<proxy port> -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain http://nufc.com
    
    
e.g.
    
    java -Dhttp.proxyHost=webproxy.mycorp.com -Dhttp.proxyPort=8080 -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain http://news.bbc.co.uk
    

