package com.projectname.project.shared.bean;

import java.io.Serializable;

public class RetrieverVersion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4000628118971982311L;
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
