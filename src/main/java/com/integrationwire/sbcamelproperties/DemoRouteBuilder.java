import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DemoRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:trigger")
                .transform().simple("ref:myBean")
                .to("log:out");
    }

    @Bean
    String myBean() {
        return "I'm Spring bean!";
    }

}

