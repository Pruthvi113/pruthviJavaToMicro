package com.zensar;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.bean.LifeCycleBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
			LifeCycleBean Lifecycle = context.getBean("Lifecycle2", LifeCycleBean.class);
			
			System.out.println(Lifecycle);
			
			context.registerShutdownHook(); //this will shutdown the container and will call destroy method.
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
    }
}
