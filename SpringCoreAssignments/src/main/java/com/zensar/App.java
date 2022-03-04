package com.zensar;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.beans.Employee;
import com.zensar.beans.EmployeeA;
import com.zensar.beans.Order;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try (
    		//Assignment 1 : Order Total
    		AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
			Map<String, Order> orders = context.getBeansOfType(Order.class);
			
			Double totalOrderPrice = 0.00;
			for (Map.Entry<String,Order> order : orders.entrySet())
			{
				System.out.println(order);
				totalOrderPrice = totalOrderPrice+order.getValue().getItem().getPrice();
			}
			System.out.println("--------------------------------------------------");
			System.out.println("Total Order Price = "+totalOrderPrice);
			System.out.println("--------------------------------------------------\n");

			
	    	//Assignment 2 : Autowiring Employee and Department
			
			System.out.println("--------------------Autowiring byName------------------------------");
			Employee employee = context.getBean("employee",Employee.class);
			System.out.println(employee);
			
			System.out.println("\n--------------------Autowiring byType------------------------------");
			Employee employee2 = context.getBean("employee2",Employee.class);
			System.out.println(employee2);
			
			System.out.println("\n--------------------Autowiring constructor------------------------------");
			Employee employee3 = context.getBean("employee3",Employee.class);
			System.out.println(employee3);
			
			System.out.println("\n--------------------Autowiring by using Annotations - @Autowired and @Qualifier------------------------------");
			EmployeeA employeeA = context.getBean("employeeA",EmployeeA.class);
			System.out.println(employeeA);
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
    	

    	
    }
}
