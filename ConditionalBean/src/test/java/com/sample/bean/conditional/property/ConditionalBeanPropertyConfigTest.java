package com.sample.bean.conditional.property;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ConditionalBeanPropertyConfig.class})
public class ConditionalBeanPropertyConfigTest {

    @Autowired
    ApplicationContext ctx;
    
    @Test
    public void testBeanA() {
        A beanA = ctx.getBean(A.class);
        assertNotNull(beanA);
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testBeanB() {
        B beanB = ctx.getBean(B.class);
        assertNotNull(beanB);
    }

    @Test(expected=NoSuchBeanDefinitionException.class)
    public void testBeanC() {
        C beanC = ctx.getBean(C.class);
        assertNotNull(beanC);
    }

}
