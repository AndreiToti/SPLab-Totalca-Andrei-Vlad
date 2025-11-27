package org.example;
import org.example.DI.ClientService;
import org.example.DI.SingletonService;
import org.example.DI.TransientService;
import org.example.filter.RequestLoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApp{

    public static void main(String[] args) {

        ApplicationContext springContext =
                SpringApplication.run(SpringApp.class, args);

        System.out.println("\nTransient");

        TransientService firstTransientBean =
                springContext.getBean(TransientService.class);
        firstTransientBean.executeOperation();

        TransientService secondTransientBean =
                springContext.getBean(TransientService.class);
        secondTransientBean.executeOperation();

        System.out.println("Identice: " +
                (firstTransientBean == secondTransientBean));

        System.out.println("\nSingleton");

        SingletonService firstSingletonBean =
                springContext.getBean(SingletonService.class);
        firstSingletonBean.executeOperation();

        SingletonService secondSingletonBean =
                springContext.getBean(SingletonService.class);
        secondSingletonBean.executeOperation();

        System.out.println("Identice: " +
                (firstSingletonBean == secondSingletonBean));

        System.out.println("\nClientComponent");

        ClientService firstClient = springContext.getBean(ClientService.class);
        firstClient.executeClientLogic();

        ClientService secondClient = (ClientService) springContext.getBean("clientService");
        secondClient.executeClientLogic();

        System.out.println("Identice: " +
                (firstClient == secondClient));
    }

    @Bean
    public FilterRegistrationBean<RequestLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestLoggingFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        System.out.println("\nLOG: RequestLoggingFilter");

        return registrationBean;
    }
}
