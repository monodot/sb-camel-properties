package com.integrationwire.sbcamelproperties;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class DemoRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:mytimer?period={{timer.period}}")
            .setBody(simple("{{greeting.word}}, this is Camel running in Spring Boot!"))
            .to("log:out");

    }

}

