package com.gfactor.jpa.core;

import javax.persistence.EntityManagerFactory;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.osgi.context.BundleContextAware;

public class EmRegisterServiceTest implements BundleContextAware {
	
	private BundleContext bctx;
	private ServiceRegistration registration;
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean emfBean;
	
	@Autowired
	private com.gfactor.jpa.core.MergingPersistenceUnitManager mgr;
	
	public void start(){
		System.out.println("mgr = " + mgr);
		System.out.println("Data source = " + mgr.getDefaultDataSource());
		System.out.println("LocalContainerEntityManagerFactoryBean = " + emfBean);
		System.out.println("getPersistenceUnitName = "+emfBean.getPersistenceUnitName());
		System.out.println("getPersistenceUnitInfo getManagedClassNames= "+emfBean.getPersistenceUnitInfo().getManagedClassNames().size());
		EntityManagerFactory emf = emfBean.getNativeEntityManagerFactory();
		System.out.println("emf = " + emf);
		System.out.println("emf get em = " + emf.createEntityManager());
		
		registration = bctx.registerService(EntityManagerFactory.class, emf, null);
		System.out.println("service register..... = " + registration); 
	}
	
	
	public void stop(){
		registration.unregister();
	}
	
	
	@Override
	public void setBundleContext(BundleContext bundleContext) {
		this.bctx = bundleContext;
		
	}
	
	
}
