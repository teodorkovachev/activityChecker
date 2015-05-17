package bg.kovachev.activityChecker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.joda.time.LocalTime;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      LocalTime currentTime = new LocalTime();
      System.out.print(currentTime);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
