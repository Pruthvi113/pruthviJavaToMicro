package com.zensar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zensar.config.JavaConfig;
import com.zensar.config.JavaConfigStereotype;

public class App 
{
    public static void main( String[] args )
    {
    //	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigStereotype.class);
    	Order order = (Order)context.getBean("order");
    	System.out.println(order);
    	
    }
}
