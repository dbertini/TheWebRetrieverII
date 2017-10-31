package com.projectname.project.server.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.projectname.project.client.service.WebRetrieverService;
import com.projectname.project.server.retrofit.services.ReportRetrieverService;
import com.projectname.project.shared.bean.ReportConfiguration;

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

	@Override
	public List<ReportConfiguration> getListaReport() {
		ReportRetrieverService reportserv = new ReportRetrieverService();
		try {
			return reportserv.getListaReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
