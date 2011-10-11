package com.gfactor.service.tableinfo;

import com.gfactor.jpa.child.tableinfo.TableInfo;

public interface IGetTableInfoService {
	public TableInfo getTableInfo(String userName,String usermail);
}
 