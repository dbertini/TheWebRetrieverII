package com.projectname.project.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("wrservice")
public interface WebRetrieverService extends RemoteService {
	String getMessaggio(String aString);
}
