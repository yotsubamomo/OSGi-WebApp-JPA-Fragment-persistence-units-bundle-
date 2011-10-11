package com.gfactor.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfactor.service.tableinfo.IGetTableInfoService;

public class Activator {

	@Autowired
	private IGetTableInfoService getTableInfoService;
//	
//	@Autowired
//	private IRegisterWicketPageBndIdentify registerWicketPageBndIdentify;
//	
	public void start(){
		getTableInfoService.getTableInfo("xenoge", "xenoge");
//		TableInfo tab = new TableInfo();
//		tab.setId(987);
//		tab.setUser_desc("yotsuba");
//		tab.setUser_mail("yotsuba");
//		tab.setUser_name("yotsuba");
//		tableInfoDao.saveTableInfo(tab);
//		
//		System.out.println("tableInfoDao = " + tableInfoDao);
		
//		System.out.println("getTableInfoService =" +getTableInfoService);
//		getTableInfoService.getTableInfo("momo", "momo");
//		Bndpageinfo bndobj = new Bndpageinfo();
//		bndobj.setId(999);
//		bndobj.setBundle_name("momo-test-bnd");
//		bndobj.setBundle_version("1.0.1");
//		bndobj.setClass_name("com.gfactor.page.html.internal.Test");		
//		bndobj.setEntry_point("testPage1");
////		getPageObjectInfoService.getBndPageInfo("test2", "1.0.1", "mains");
//		System.out.println("----------------------->>>>>");
//		registerWicketPageBndIdentify.registerPageInfo(bndobj);
	}
	
	
	public void stop(){
		
	}
}
