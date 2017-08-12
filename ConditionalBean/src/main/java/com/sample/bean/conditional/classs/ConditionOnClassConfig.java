package com.sample.bean.conditional.classs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;
import com.sample.bean.conditional.model.C;

@Configuration
public class ConditionOnClassConfig {

    @Bean
    @ConditionalOnClass(value={java.util.HashMap.class})
    public A beanA(){
        return new A(); // will get created as HashMap class is on the classpath
    }
    
    @Bean
    @ConditionalOnClass(name="com.sample.Dummy")
    public B beanB(){
        return new B(); // won't be created as Dummy class is not on classpath
    }
    
    @Bean
    @ConditionalOnClass(value=com.sample.bean.conditional.model.ASimpleInt.class)
    public C beanC(){
        return new C(); // ASimpleInt is on the classpath in the project. 
                        //So, C's instance will be created.
    }
    
}
