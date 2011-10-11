package com.gfactor.jpa.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;

import com.gfactor.osgi.api.export.util.GetResourceFileUtil;


/**
 * Basic PersistenceUnitManage extends DefaultPersistenceUnitManager 
 * and just override setPersistenceXmlLocations(String[]) to catch all persistence*.xml files name.
 * @author momo
 *
 */
public class HostPersistenceUnitManager extends DefaultPersistenceUnitManager implements ApplicationContextAware {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	private final String CLASSPATHPREFIX = "classpath:META-INF/";
	
	private ApplicationContext ctx;
	
	/**
	 * Modify DefaultPersistenceUnitManager to support get all  persistence*.xml file on  /META-INF/, 
	 *
	 */
	@Override
	public void setPersistenceXmlLocations(String[] persistenceXmlLocations) {
		
		logger.info("HostPersistenceUnitManager setPersistenceXmlLocations = " + persistenceXmlLocations);
		super.setPersistenceXmlLocations(persistenceXmlLocations);
		String[] xmlFileList = null;
		
		if(isFolderPathWithOutFileName(persistenceXmlLocations)){		
			xmlFileList = GetResourceFileUtil.getFileListByApplicatioinContext(xmlFileList[0], this.ctx);			
			String[] filterXmlFileList = null;											
			filterXmlFileList = filterAllPersistenceFile(xmlFileList);
			
			logger.info("HostPersistenceUnitManager , xmlFileList =" + xmlFileList);
			logger.info("HostPersistenceUnitManager , filterXmlFileList =" + filterXmlFileList);
			
			super.setPersistenceXmlLocations(filterXmlFileList);					
		}else{
			super.setPersistenceXmlLocations(persistenceXmlLocations);
		}
		
	}

	private String[] filterAllPersistenceFile(String[] xmlFileList) {
		//return default persistence.xml file
		if(xmlFileList == null) return new String[] {CLASSPATHPREFIX+"persistence.xml"};		
		
		String[] filterXmlFileList;
		List<String> xmlList = Arrays.asList(xmlFileList);
		List<String> filterList = new ArrayList<String>();
		
		for (int i = 0; i < xmlList.size(); i++) {
			if(xmlList.get(i).indexOf("persistence") > 0){
				logger.info("filterAllPersistenceFile , " + CLASSPATHPREFIX + xmlList.get(i));
				filterList.add(CLASSPATHPREFIX + xmlList.get(i));
			}
		}
		
		filterXmlFileList = (String[]) filterList.toArray();
		return filterXmlFileList;
	}

	
	private boolean isFolderPathWithOutFileName(String[] persistenceXmlLocations) {
		return persistenceXmlLocations.length == 1 && persistenceXmlLocations[0].indexOf("xml") < 0;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}
}	
