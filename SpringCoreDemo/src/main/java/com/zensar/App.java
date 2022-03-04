package com.zensar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml"); // SPRING CONTAINER 1 
    	//ApplicationContext context2 = new FileSystemXmlApplicationContext("/src/main/resources/context.xml"); // SPRING CONTAINER 2 
    	//Order order = (Order)context.getBean("order"); //another way for this below
    	Order order1 = context.getBean("order2", Order.class);
    	System.out.println(order1.hashCode());
    	Order order2 = context.getBean("order2", Order.class);
    	System.out.println(order2.hashCode());
    	// SINGLETON - since single Instance of the class is created PER CONTAINER (not link java singleton, where single instance is created per JVM) (at container startup only). hashCode for multiple objects of same class will be same. 
    	// PROTOTYPE - new instance/object everytime it is called hashCode for multiple objects of same class will be different for every instance. 
    	//context.registerShutdownHook();//destroy method
    	
    //	Order order3 = context.getBean("order3", Order.class);//inner bean
    	Order order4 = context.getBean("newOrder", Order.class);//parent bean / abstract bean

    	
    	System.out.println(order4);
    }
}
