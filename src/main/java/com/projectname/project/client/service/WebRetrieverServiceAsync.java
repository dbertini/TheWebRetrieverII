package com.projectname.project.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WebRetrieverServiceAsync {
	void getMessaggio(String input, AsyncCallback<String> callback);
}
