package com.sample.bean.conditional.classs;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ConditionOnMissingClassConfig.class)
public class ConditionOnMissingClassConfigTest {

    @Autowired
    ApplicationContext ctx;
    
    @Test
    public void testBeanA() {
        A beanA = ctx.getBean("beanA",A.class);
        assertNotNull(beanA);
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testBeanB() {
        B beanB = ctx.getBean("beanB",B.class);
        assertNotNull(beanB);
    }

}
