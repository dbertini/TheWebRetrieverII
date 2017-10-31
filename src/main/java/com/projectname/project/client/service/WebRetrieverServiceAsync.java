package com.projectname.project.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.projectname.project.shared.bean.ReportConfiguration;

public interface WebRetrieverServiceAsync {
	void getMessaggio(String input, AsyncCallback<String> callback);
	void getListaReport(AsyncCallback<List<ReportConfiguration>> callback);
}
