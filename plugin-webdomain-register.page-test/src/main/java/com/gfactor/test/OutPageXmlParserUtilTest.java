package com.gfactor.test;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gfactor.osgi.api.export.util.GetResourceFileUtil;
import com.gfactor.osgi.api.export.util.OutPageXmlParserUtil;

public class OutPageXmlParserUtilTest implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(OutPageXmlParserUtilTest.class);
    private ApplicationContext ctx;
	public void start(){
		File f = new File("META-INF/OutPageInfo.xml");
		logger.info("file fexists = "+f.exists());
		logger.info("file fgetName = "+f.getName());		
//		logger.info("OutPageXmlParserUtil return ="+OutPageXmlParserUtil.getInputFileInfo(f));
		File f2 = GetResourceFileUtil.getFileByApplicationContext("META-INF/OutPageInfo.xml", this.ctx);
		logger.info("file fexists = "+f2.exists());
		logger.info("file fgetName = "+f2.getName());
	}
	
	public void stop(){
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}

}
