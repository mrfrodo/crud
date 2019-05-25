package no.frode.cruddemo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(MyRoute.class);

    @Override
    public void configure() throws Exception {
        logger.info("__configuring camel route");
        from("file:/tmp/inputFile?noop=true")
                .log("Read from the input file")
                .to("file:/tmp/outputFile")
                .log("Written to output file");
    }
}
