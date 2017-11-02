package com.projectname.project.server.retrofit.interfaces;
import java.util.List;

import com.projectname.project.shared.bean.ReportConfiguration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReportRetrieverIterface {
	@GET("reports/reportList")
	Call<List<ReportConfiguration>> reportList();
	
	@GET("reports/reportDetail/{reportname}")
	Call<ReportConfiguration> reportDetail(@Path("reportname")String reportname);
	
	@GET("reports/runReport/{reportname}")
	Call<String> runReport(@Path("reportname")String reportname);
	
}
