package com.zensar;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.beans.Order;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml"); // SPRING CONTAINER 1 
    	Order order = context.getBean("order", Order.class);
    	
    	System.out.println(order);
    }
}
