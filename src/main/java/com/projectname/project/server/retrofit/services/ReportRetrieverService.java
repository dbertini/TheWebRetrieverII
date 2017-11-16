package com.projectname.project.server.retrofit.services;

import java.util.ArrayList;
import java.util.List;

import com.projectname.project.server.retrofit.interfaces.ReportRetrieverIterface;
import com.projectname.project.server.utils.ApplicationConstants;
import com.projectname.project.shared.bean.DataSourceConfiguration;
import com.projectname.project.shared.bean.ReportConfiguration;
import com.projectname.project.shared.bean.RetrieverVersion;

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
	
	
	public ReportConfiguration runReport(String aReportName) throws Exception {
		Call<ReportConfiguration> call = service.runReport(aReportName);
		Response<ReportConfiguration> response = call.execute();
		if(response.errorBody()!=null){
			return null;
		} else{
			return response.body();
		}
	}

	public ArrayList<DataSourceConfiguration> getListaDataSources() throws Exception {
		Call<List<DataSourceConfiguration>> call = service.dataSourceList();
		Response<List<DataSourceConfiguration>> response = call.execute();
		if(response.errorBody()!=null){
			return null;
		} else{
			return (ArrayList<DataSourceConfiguration>)response.body();
		}
	}

	public DataSourceConfiguration getDataSourceDetail(String aDataSourceName) throws Exception {
		Call<DataSourceConfiguration> call = service.datasourceDetail(aDataSourceName);
		Response<DataSourceConfiguration> response = call.execute();
		System.out.println("Responde trovare");
		System.out.println(response);
		if(response.errorBody()!=null){
			return null;
		} else{
			return response.body();
		}
	}
	
	
	public String getRetrieverVersion() throws Exception {
		Call<RetrieverVersion> call = service.getRetrieverVersion();
		Response<RetrieverVersion> response = call.execute();
		if(response.errorBody()!=null){
			return null;
		} else{
			return response.body().getVersion();
		}
	}
	
}
