package com.project.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.project.config.ApplicationDBConfig;
import com.project.config.ApplicationWebConfig;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    //DBConfig File input to FrontController
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ApplicationDBConfig.class};
	}
     // for MVC Configuration
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ApplicationWebConfig.class};
	}
    // For Url Mappings
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
