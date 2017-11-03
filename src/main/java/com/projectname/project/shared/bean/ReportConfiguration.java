package com.projectname.project.shared.bean;

import java.io.Serializable;

public class ReportConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1330061910105552212L;

	private String export;
	private long lastStartTime;
	private long lastStopTime;
	private String executionId;
	private String name;
	private String sql;
	private String datasource;
	private String cron;
	private String description;
	private String recipient;
	private String cclist;
	private String ccnlist;
	private String template;
	private String filename;
	public String getExport() {
		return export;
	}
	public void setExport(String export) {
		this.export = export;
	}
	public long getLastStartTime() {
		return lastStartTime;
	}
	public void setLastStartTime(long lastStartTime) {
		this.lastStartTime = lastStartTime;
	}
	public long getLastStopTime() {
		return lastStopTime;
	}
	public void setLastStopTime(long lastStopTime) {
		this.lastStopTime = lastStopTime;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getCclist() {
		return cclist;
	}
	public void setCclist(String cclist) {
		this.cclist = cclist;
	}
	public String getCcnlist() {
		return ccnlist;
	}
	public void setCcnlist(String ccnlist) {
		this.ccnlist = ccnlist;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
