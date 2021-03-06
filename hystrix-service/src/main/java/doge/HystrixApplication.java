package doge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This will be available at <A href="://127.0.0.1:7980/">localhost:7980</a>.
 * <p>
 * When it opens, add the Hystrix stream for your service, like http://localhost:8081/hystrix.stream for the Accounts endpoint.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableHystrixDashboard
@EnableEurekaClient
public class HystrixApplication {

    @Bean
    SpringClientFactory springClientFactory (){
        return new SpringClientFactory() ;
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}

@Controller
class HystrixDashboardController {

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix/index.html";
    }

}