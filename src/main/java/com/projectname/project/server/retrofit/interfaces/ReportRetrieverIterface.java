package com.projectname.project.server.retrofit.interfaces;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReportRetrieverIterface {
	@GET("notifica/notificaServizio")
	Call<String> notifica(@Query("inputData") String inputData);
}
