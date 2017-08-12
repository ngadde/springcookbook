package com.sample.bean.conditional.resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;

@Configuration
public class ConditionalOnResourceConfig {
    
    @Bean
    @ConditionalOnResource(resources={"classpath:application.properties"})
    public A beanA(){
        return new A(); // will initiate as application.properties is in 
                        // classpath.
    }

    @Bean
    @ConditionalOnResource(resources={"file:///e:/doc/data.txt"})
    public B beanB(){
        return new B(); // will not initialize as the file is not
                        // present in the given location.
    }
}
