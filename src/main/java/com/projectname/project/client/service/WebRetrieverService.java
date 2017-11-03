package com.projectname.project.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.projectname.project.shared.bean.DataSourceConfiguration;
import com.projectname.project.shared.bean.ReportConfiguration;

@RemoteServiceRelativePath("wrservice")
public interface WebRetrieverService extends RemoteService {
	String getMessaggio(String aString);
	ArrayList<ReportConfiguration> getListaReport();
	ReportConfiguration getReportDetail(String aReportName);
	String runReport(String aReportName);
	ArrayList<DataSourceConfiguration> getListaDataSources();
	DataSourceConfiguration getDataSourceDetail(String aDataSourcetName);
	String getRetrieverVersion();
}
