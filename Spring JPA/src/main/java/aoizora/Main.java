package aoizora;

import aoizora.config.SpringConfig;
import aoizora.model.Greeting;
import aoizora.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        GreetingService service = ctx.getBean(GreetingService.class);

        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello");
        greeting.setTarget("World");

        service.save(greeting);
    }
}
