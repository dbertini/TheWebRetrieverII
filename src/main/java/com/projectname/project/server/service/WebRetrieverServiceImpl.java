package com.projectname.project.server.service;

import java.util.ArrayList;

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
		return aString + "!!!!!!!!!!!";
	}

	@Override
	public ArrayList<ReportConfiguration> getListaReport() {
		ReportRetrieverService reportserv = new ReportRetrieverService();
		try {
			return reportserv.getListaReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	@Override
	public ReportConfiguration getReportDetail(String aReportName) {
		ReportRetrieverService reportserv = new ReportRetrieverService();
		try {
			return reportserv.getReportDetail(aReportName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String runReport(String aReportName) {
		ReportRetrieverService reportserv = new ReportRetrieverService();
		try {
			return reportserv.runReport(aReportName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
