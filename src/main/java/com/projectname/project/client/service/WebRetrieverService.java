package com.projectname.project.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.projectname.project.shared.bean.ReportConfiguration;

@RemoteServiceRelativePath("wrservice")
public interface WebRetrieverService extends RemoteService {
	String getMessaggio(String aString);
	List<ReportConfiguration> getListaReport();
}
