/**
 * 
 */
package com.gfactor.service.tableinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gfactor.jpa.child.tableinfo.TableInfo;
import com.gfactor.jpa.tableinfo.dao.TableInfoDao;


/**
 * @author momo
 *
 */ 
public class GetTableInfoServiceImpl implements IGetTableInfoService {
	
	@Autowired
	private TableInfoDao tableinfodao;
	/* (non-Javadoc)
	 * @see com.gfactor.service.tableinfo.IGetTableInfoService#getTableInfo(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public TableInfo getTableInfo(String userName, String usermail) {
		TableInfo tableinfo = tableinfodao.getTableInfo("momo", "momo");
		System.out.println("result = tableinfo ");
		TableInfo tableinfo2 = new TableInfo();
		tableinfo2.setId(150);
		tableinfo2.setUser_desc("xenoge");
		tableinfo2.setUser_mail("xenoge");
		tableinfo2.setUser_name("xenoge");
		tableinfodao.saveTableInfo(tableinfo2);
		return tableinfo;
	}

}
