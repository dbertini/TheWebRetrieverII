package com.projectname.project.shared.bean;

import java.io.Serializable;

public class DataSourceConfiguration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1948321593102929580L;
	private String name;
	private String url;
	private String username;
	private String password;
	private String driver;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
