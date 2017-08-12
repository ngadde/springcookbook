package com.sample.bean.conditional.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.ASimpleInt;
import com.sample.bean.conditional.model.B;
import com.sample.bean.conditional.model.BSimpleInt;
import com.sample.bean.conditional.model.C;
import com.sample.bean.conditional.model.SimpleInt;

@Configuration
public class ConditionalOnBeanConfig {

    @Bean
    public A beanA(){
        return new A(); // will initialize as normal
    }
    
    @Bean
    @ConditionalOnBean(name="beanA")
    public B beanB(){
        return new B(); // it will initialize as beanA is present in the beanFactory.
    }
    
    @Bean
    @ConditionalOnBean
    public C beanC(){
        return new C(); // will not get initialized as there is no bean with return type C in BeanFactory.
    }
    
    @Bean
    public SimpleInt beanAInt(){
        return new ASimpleInt();
    }
    
    @Bean
    @ConditionalOnBean
    public SimpleInt beanBInt(){
        return new BSimpleInt();
    }
}
