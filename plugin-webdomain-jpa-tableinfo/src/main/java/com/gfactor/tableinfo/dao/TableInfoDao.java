package com.gfactor.tableinfo.dao;

import java.util.List;

import com.gfactor.tableinfo.jpa.TableInfo;


public interface TableInfoDao {
	
	public TableInfo findByEntry(TableInfo tableInfo);
	public List<TableInfo> findTableInfoList(String userName, String userMail);
	public TableInfo getTableInfo(String userName,String usermail);
	public void saveTableInfo(TableInfo tableInfo);
	public TableInfo update(TableInfo tableInfo);
	public void delete(TableInfo tableInfo);
	public void deleteExpiredTableInfo(TableInfo tableInfo);
}
