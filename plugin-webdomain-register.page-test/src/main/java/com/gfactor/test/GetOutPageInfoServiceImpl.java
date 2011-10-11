/**
 * 
 */
package com.gfactor.test;

import java.io.File;
import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gfactor.osgi.api.export.iface.IGetOutPageInfoService;
import com.gfactor.osgi.api.export.util.GetResourceFileUtil;
import com.gfactor.osgi.api.export.util.OutPageXmlParserUtil;

/**
 * @author momo
 *
 */
class GetOutPageInfoServiceImpl implements IGetOutPageInfoService,ApplicationContextAware {

	private ApplicationContext ctx;
	
	/* (non-Javadoc)
	 * @see com.gfactor.osgi.api.export.iface.IGetOutPageInfoService#getOutPageInfoMap()
	 */
	@Override
	public HashMap<String, String> getOutPageInfoMap(String className,String outPage){
		File xmlFile = GetResourceFileUtil.getFileByApplicationContext("META-INF/OutPageInfo.xml", ctx);
		return OutPageXmlParserUtil.getOutPageInfoMapByFullyClassName(className, outPage, xmlFile);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;		
	}

}
