package com.gfactor.folder;


import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.osgi.context.BundleContextAware;

import com.gfactor.pageinfo.jpa.Bndpageinfo;
import com.gfactor.pageinfo.service.IRegisterWicketPageBndIdentify;


public class BundleActivator implements BundleContextAware {
	
	private BundleContext bundleCtx;
	private Bundle bundle;
	private Bndpageinfo bndobj;
	 
public IRegisterWicketPageBndIdentify getRegisterWicketPageBndIdentify() {
		return registerWicketPageBndIdentify;
	}

//	public void setRegisterWicketPageBndIdentify(
//			IRegisterWicketPageBndIdentify registerWicketPageBndIdentify) {
//		this.registerWicketPageBndIdentify = registerWicketPageBndIdentify;
//	}

	@Autowired
	private IRegisterWicketPageBndIdentify registerWicketPageBndIdentify;
	
	public void start(){
		System.out.println("return class name = ");
		
		this.bndobj.setClass_name("com.gfactor.page.html.internal.Test");		
		this.bndobj.setEntry_point("testPage1");
		System.out.println("bndobj init finished = " + this.bndobj); 
		System.out.println("registerWicketPageBndIdentify = "+ registerWicketPageBndIdentify);
		registerWicketPageBndIdentify.registerPageInfo(this.bndobj); 
//		Bndpageinfo bndobj = new Bndpageinfo();
//		bndobj.setId(299);		
//		bndobj.setBundle_name("plugin-webdomain-page-html");
//		bndobj.setBundle_version("1.0.2");
//		bndobj.setClass_name("com.gfactor.page.html.internal.NonePage");
//		bndobj.setEntry_point("imagePage1");
//		registerWicketPageBndIdentify.registerPageInfo(bndobj);
	} 
	
	public void stop(){
		System.out.println("unregister bndobj = "+ this.bndobj);
//		registerWicketPageBndIdentify.unregisterPageInfo(this.bndobj);
		System.out.println("bundle stop ,bndobj = " + bndobj);
	}

	public void setBundleContext(BundleContext bundleContext) {
		this.bundleCtx = bundleContext;
		this.bundle = this.bundleCtx.getBundle();
		setBndObject();
		System.out.println("get bundle = "+ this.bundle);
		System.out.println("bundle id = "+this.bundle.getBundleId());
//		registerWicketPageBndIdentify.unregisterPageInfo(this.bndobj);
	}
	
	public void setBndObject(){		
		bndobj = new Bndpageinfo();
		this.bndobj.setBundle_name(bundle.getSymbolicName());		
		this.bndobj.setBundle_version(bundle.getVersion().toString());
		this.bndobj.setId(bundle.getBundleId());
	}
}
