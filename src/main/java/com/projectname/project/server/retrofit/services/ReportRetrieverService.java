package com.projectname.project.server.retrofit.services;

import java.util.ArrayList;
import java.util.List;

import com.projectname.project.server.retrofit.interfaces.ReportRetrieverIterface;
import com.projectname.project.server.utils.ApplicationConstants;
import com.projectname.project.shared.bean.ReportConfiguration;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReportRetrieverService {
	
	private ReportRetrieverIterface service;
	
	public ReportRetrieverService() {
		init();
	}
	
	private void init() {
		String baseUrl = ApplicationConstants.RETRIEVER_URL;
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		this.service = retrofit.create(ReportRetrieverIterface.class);
	}

	public ArrayList<ReportConfiguration> getListaReport() throws Exception {
		Call<List<ReportConfiguration>> call = service.reportList();
		
		Response<List<ReportConfiguration>> response = call.execute();
		
		if(response.errorBody()!=null){
			return null;
		} else{
			List<ReportConfiguration> confs = response.body();
			return (ArrayList<ReportConfiguration>)confs;
		}
	}
	
	public ReportConfiguration getReportDetail(String aReportName) throws Exception {
		Call<ReportConfiguration> call = service.reportDetail(aReportName);
		Response<ReportConfiguration> response = call.execute();
		if(response.errorBody()!=null){
			return null;
		} else{
			return response.body();
		}
	}
	
	
	public String runReport(String aReportName) throws Exception {
		Call<String> call = service.runReport(aReportName);
		Response<String> response = call.execute();
		if(response.errorBody()!=null){
			return null;
		} else{
			return response.body();
		}
	}
}
