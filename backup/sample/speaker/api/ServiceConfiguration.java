package com.sample.speaker.api;


import org.springframework.context.annotation.*;

@Configuration
public class ServiceConfiguration {

	@Bean
	public ServiceFactory serviceFactory() {
		return (ServiceFactory) new ServiceFactory();
	}

/*	@Bean
	public ServiceLocatorFactoryBean serviceLocatorFactory() {
		ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(ServiceFactory.class);
		return bean;
	}*/
}
