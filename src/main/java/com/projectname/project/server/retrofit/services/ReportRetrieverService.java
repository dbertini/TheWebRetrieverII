package com.projectname.project.server.retrofit.services;

import java.util.List;

import com.projectname.project.server.retrofit.interfaces.ReportRetrieverIterface;
import com.projectname.project.server.utils.ApplicationConstants;
import com.projectname.project.shared.bean.ReportConfiguration;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReportRetrieverService {

	public List<ReportConfiguration> getListaReport() throws Exception {
		String baseUrl = ApplicationConstants.RETRIEVER_URL;
		
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		
		ReportRetrieverIterface service = retrofit.create(ReportRetrieverIterface.class);
		
		Call<List<ReportConfiguration>> call = service.reportList();
		
		Response<List<ReportConfiguration>> response = call.execute();
		
		if(response.errorBody()!=null){
			return null;
		} else{
			List<ReportConfiguration> confs = response.body();
			return confs;
		}
	}
}
