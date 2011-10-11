package com.gfactor.fragment.host;

import java.io.File;
import java.io.IOException;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.osgi.context.BundleContextAware;


public class HostActivator implements ApplicationContextAware,BundleContextAware{
    private static final Logger logger = LoggerFactory.getLogger(HostActivator.class);

	private ApplicationContext ctx;
	private BundleContext btx;
	
	public void start(){
		System.out.println("ctx = " +ctx);
		File f = getResourceFile("classpath:/META-INF/",ctx);
		System.out.println("f = "+ f);
		System.out.println("f.exists = "+ f.exists());
		Bundle bundle = btx.getBundle();
		
		if(f.exists()){
			System.out.println("f listFiles = " + f.listFiles().length);
		}
		
		File f2 = getResourceFile("/META-INF/",ctx);
		if(f2 != null){
			System.out.println("f2.exists = "+ f2.exists());
			if(f2.exists()){
				System.out.println("f2 listFiles = " + f2.listFiles().length);
			}
		}
		
		
		File f3 = getResourceFile("classpath:/META-INF/child",ctx);
		if(f3 != null){
			System.out.println("f3.exists = "+ f3.exists());
			if(f3.exists()){
				System.out.println("f3 listFiles = " + f3.listFiles().length);
			}
		}
		
	}
	
	
	public void stop(){
		
		
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
	this.ctx = applicationContext;
		
	}


	@Override
	public void setBundleContext(BundleContext bundleContext) {
		this.btx = bundleContext;
		
	}
	
	private static File getResourceFile(String classPathStr,ApplicationContext ctx) {
		logger.info("GetResourceFileUtil getResourceFile....");
		logger.info("classpathstr = " + classPathStr);
		logger.info("ApplicationContext = " + ctx);
		
		File returnFile = null;
		Resource rs = ctx.getResource(classPathStr);
		logger.info("Resource = " + rs);
		
		if(rs != null){
			try {
				returnFile =  rs.getFile();
			} catch (IOException e) {
				logger.error("getResourceFile fail... " + e);
			} 
		}
		logger.info("getResourceFile  = " + returnFile);
		
		return returnFile;		
		
	}
}
