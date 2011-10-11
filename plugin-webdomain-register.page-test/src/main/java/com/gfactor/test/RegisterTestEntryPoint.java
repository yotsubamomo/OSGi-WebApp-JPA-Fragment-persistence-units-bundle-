/**
 * 
 */
package com.gfactor.test;

import java.util.HashMap;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.osgi.context.BundleContextAware;

import com.gfactor.osgi.api.export.util.BundleContextInfoUtil;
import com.gfactor.tracker.iface.RegisterEntryPoint;

/**
 * @author momo
 *
 */
public class RegisterTestEntryPoint implements RegisterEntryPoint,BundleContextAware{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	private BundleContext bundleContext;
	
	/* (non-Javadoc)
	 * @see com.gfactor.tracker.iface.RegisterEntryPoint#getRegisterPageInfoMap()
	 */
	@Override
	public HashMap<String, String> getRegisterPageInfoMap() {
		logger.info("RegisterTestEntryPoint , getMap....");
		HashMap<String,String> resultMap = BundleContextInfoUtil.getBundleInfoMapWithClassAndEntrypoint(this.bundleContext, "com.gfactor.test", "test_main");
		
		logger.info("RegisterTestEntryPoint map = "+resultMap);
		return resultMap;
	}

	@Override
	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
		
	}

}
