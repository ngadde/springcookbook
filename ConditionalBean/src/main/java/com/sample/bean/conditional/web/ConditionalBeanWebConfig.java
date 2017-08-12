package com.sample.bean.conditional.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;

@Configuration
public class ConditionalBeanWebConfig {
    
    @Bean
    @ConditionalOnWebApplication
    public A beanA(){
        return new A();
    }

    @Bean
    @ConditionalOnNotWebApplication
    public B beanB(){
        return new B();
    }
}
