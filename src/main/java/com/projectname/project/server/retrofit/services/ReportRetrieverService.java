package com.projectname.project.server.retrofit.services;

import com.projectname.project.server.retrofit.interfaces.ReportRetrieverIterface;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReportRetrieverService {

	public void getListaReport() throws Exception {
		String baseUrl = "";
		
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		
		ReportRetrieverIterface service = retrofit.create(ReportRetrieverIterface.class);
		
		Call<String> call = service.notifica("Input");
		
		Response<String> response = call.execute();
		
		if(response.errorBody()!=null){
			System.out.println("Errore!!!!!");
		} else{
			System.out.println("OOOOOKKKKKK");			
		}
	}
}
