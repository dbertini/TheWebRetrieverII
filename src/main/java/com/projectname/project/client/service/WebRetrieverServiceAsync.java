package com.projectname.project.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.projectname.project.shared.bean.DataSourceConfiguration;
import com.projectname.project.shared.bean.ReportConfiguration;

public interface WebRetrieverServiceAsync {
	void getMessaggio(String input, AsyncCallback<String> callback);
	void getListaReport(AsyncCallback<ArrayList<ReportConfiguration>> callback);
	void getReportDetail(String aReportName, AsyncCallback<ReportConfiguration> callback);
	void runReport(String aReportName, AsyncCallback<ReportConfiguration> callback);
	void getListaDataSources(AsyncCallback<ArrayList<DataSourceConfiguration>> callback);
	void getDataSourceDetail(String aDataSourcetName, AsyncCallback<DataSourceConfiguration> callback);
	void getRetrieverVersion(AsyncCallback<String> callback);
}
