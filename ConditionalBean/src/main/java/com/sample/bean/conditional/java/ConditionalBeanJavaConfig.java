package com.sample.bean.conditional.java;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.JavaVersion;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;

@Configuration
public class ConditionalBeanJavaConfig {

    @Bean
    @ConditionalOnJava(value=JavaVersion.EIGHT)
    public A beanA(){
        return new A();
    }

    @Bean
    @ConditionalOnJava(value=JavaVersion.SEVEN,range=Range.OLDER_THAN)
    public B beanB(){
        return new B();
    }
}
