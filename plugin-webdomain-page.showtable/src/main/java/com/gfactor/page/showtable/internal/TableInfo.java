package com.gfactor.page.showtable.internal;

import org.apache.wicket.IClusterable;

public class TableInfo implements IClusterable{
	private long id;
	private String user_name;
	private String user_desc;
	private String user_mail;
	
	public TableInfo(){
		
	}
	
	@Override
	public String toString()
	{
		return "[TableInfo id=" + id + " user_name=" + user_name + " user_desc=" + user_desc +
				" user_mail=" + user_mail + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_desc() {
		return user_desc;
	}

	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	
	
	
}
