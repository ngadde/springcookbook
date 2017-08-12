package com.sample.bean.conditional.bean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;
import com.sample.bean.conditional.model.C;
import com.sample.bean.conditional.model.SimpleInt;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ConditionalOnBeanConfig.class)
public class ConditionalOnBeanConfigTest {

    @Autowired
    ApplicationContext context;
    
    @Test
    public void testBean() {
        A beanA = context.getBean("beanA",A.class);
        B beanB = context.getBean("beanB",B.class);
        
        SimpleInt beanAInt = context.getBean("beanAInt",SimpleInt.class);
        SimpleInt beanBInt = context.getBean("beanBInt",SimpleInt.class);
        
        assertNotNull(beanA);
        assertNotNull(beanB);
        assertNotNull(beanAInt);
        assertNotNull(beanBInt);
    }

   @Test(expected=NoSuchBeanDefinitionException.class)
   public void testBean1(){
       A beanA = context.getBean("beanA",A.class);
       C beanC = context.getBean("beanC",C.class);
       
       assertNotNull(beanA);
       assertNotNull(beanC);
   }

}
