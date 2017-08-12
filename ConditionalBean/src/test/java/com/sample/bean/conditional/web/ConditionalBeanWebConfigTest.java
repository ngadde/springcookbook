package com.sample.bean.conditional.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.bean.conditional.model.A;
import com.sample.bean.conditional.model.B;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ConditionalBeanWebConfig.class},webEnvironment=WebEnvironment.NONE)
public class ConditionalBeanWebConfigTest {

    @Autowired
    ApplicationContext ctx;
    
    @Test
    public void testBeanAForWeb() {
        A beanA = ctx.getBean(A.class);
        assertNotNull(beanA);
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testBeanBForWeb() {
        B beanB = ctx.getBean(B.class);
        assertNotNull(beanB);
    }
    
    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testBeanAForNotWeb() {
        A beanA = ctx.getBean(A.class);
        assertNotNull(beanA);
    }

    @Test
    public void testBeanBForNotWeb() {
        B beanB = ctx.getBean(B.class);
        assertNotNull(beanB);
    }

}
