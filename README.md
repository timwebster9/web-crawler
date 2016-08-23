# web-crawler

## Building
### Requirements
* Apache Maven
* JDK 8

To build, from the project root directory (containing pom.xml) run:
    
    mvn clean package
    

## Running

To run the application, from the project root directory:
    
    java -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain <URL>
    
where `<URL>` is a URL of your choice.  **You must include a protocol prefix** (e.g. http://mydomain.com)

e.g.
    
    java -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain http://news.bbc.co.uk
    
### Running Behind a Proxy Server

If you are behind a proxy server, include the following system properties with appropriate values:

    
    java -Dhttp.proxyHost=<proxy hostname> -Dhttp.proxyPort=<proxy port> -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain http://nufc.com
    
    
e.g.
    
    java -Dhttp.proxyHost=webproxy.mycorp.com -Dhttp.proxyPort=8080 -cp target/web-crawler-1.0-SNAPSHOT.jar org.timw.AppMain http://news.bbc.co.uk
    

The output will display the root page with no indent, page links with a single indent, and static content with a double indent.  e.g.
    
    http://news.bbc.co.uk
        http://www.bbc.co.uk/news/help-17655000
        http://www.bbc.co.uk/news/10628323
        http://www.bbc.co.uk/news/20039682
        http://www.bbc.co.uk/news/
            http://news.bbc.co.uk///static.chartbeat.com/js/chartbeat_mab.js
            http://static.bbci.co.uk/frameworks/requirejs/lib.js
            https://fig.bbc.co.uk/frameworks/fig/1/fig.js
            http://static.bbci.co.uk/frameworks/barlesque/3.20.4/orb/4/script/orb/api.min.js

## NOTES  
*The application will probably run forever because I ran out of time before I could implement a 'history' feature, and recursive linking will probably occur.  It can be stopped with Ctrl+C.
*'real' logging would normally be used intead of stdout
* Not enough tests!
* Would probably also normally use a Spring Boot CommandLineRunner.  The dependency injection makes individual components easier to test in isolation.

