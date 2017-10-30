package com.projectname.project.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.projectname.project.client.service.WebRetrieverService;

public class WebRetrieverServiceImpl extends RemoteServiceServlet implements WebRetrieverService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5752858664038153590L;

	@Override
	public String getMessaggio(String aString) {
		
		System.out.println("CAZZO è passato da qui!!!!");
		return aString + "!!!!!!!!!!!";
	}

}
