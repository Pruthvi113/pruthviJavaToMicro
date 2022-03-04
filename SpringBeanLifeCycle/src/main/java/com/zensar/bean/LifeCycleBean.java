package com.zensar.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean{
	private String title;
	
	public LifeCycleBean() {
		System.out.println("INSIDE DEFAULT CONSTRUCTOR --> LifeCycleBean()");

	}
	
	public LifeCycleBean(String title) {
		System.out.println("INSIDE PARAMETERIZED CONSTRUCTOR --> LifeCycleBean(String title)");
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		System.out.println("INSIDE SETTER --> setTitle(String title)");
		this.title = title;
	}

	@Override
	public String toString() {
		return "LifeCycleBean [title=" + title + "]";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("INSIDE setBeanName (BeanNameAware interface) Bean id/name is "+name);
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("INSIDE afterPropertiesSet (InitializingBean interface) ");
		
	}
	
	public void myInit() {
		System.out.println("myInit");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("INSIDE destroy (DisposableBean interface)");
		
	}
	
	
}
