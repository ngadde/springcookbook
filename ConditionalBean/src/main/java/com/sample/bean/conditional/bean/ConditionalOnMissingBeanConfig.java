package com.sample.bean.conditional.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;
import com.sample.bean.conditional.model.C;

@Configuration
public class ConditionalOnMissingBeanConfig {

    @Bean
    public A beanA(){
        return new A(); // will initialize as normal
    }
    
    @Bean
    @ConditionalOnMissingBean(name="beanA")
    public B beanB(){
        return new B(); // it will not initialize as 
                        // beanA is present in the beanFactory.
    }
    
    @Bean
    @ConditionalOnMissingBean(name="beanD")
    public C beanC(){
        return new C(); // will get initialized as there is no 
                        // bean with name beanD in BeanFactory.
    }
   
}
