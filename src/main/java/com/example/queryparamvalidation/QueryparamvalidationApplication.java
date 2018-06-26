package com.example.queryparamvalidation;

import com.example.queryparamvalidation.models.Widget;
import com.example.queryparamvalidation.utils.ArgsChecker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueryparamvalidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryparamvalidationApplication.class, args);
    }


    @Bean(name="widgetArgsChecker")
    public ArgsChecker<Widget> widgetArgsChecker(){
        return new ArgsChecker<Widget>(Widget.class);
    }

/*    //Other ArgsCheckers of different types may be used by other controllers.
    @Bean(name="fooArgsChecker")
    public ArgsChecker<Foo> fooArgsChecker(){
        return new ArgsChecker<Foo>(Foo.class);
    }*/
}
