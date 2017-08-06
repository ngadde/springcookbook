package com.sample.bean.conditional.property;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;
import com.sample.bean.conditional.model.C;

@Configuration
public class ConditionalBeanPropertyConfig {
    
    @Bean
    @ConditionalOnProperty(name="test.property", havingValue="A")
    public A beanA(){
        return new A();
    }

    @Bean
    @ConditionalOnProperty(name="test.property", havingValue="B")
    public B beanB(){
        return new B();
    }
    
    @Bean
    @ConditionalOnProperty(name="test.property", havingValue="C",matchIfMissing=true)
    public C beanC(){
        return new C();
    }
}
