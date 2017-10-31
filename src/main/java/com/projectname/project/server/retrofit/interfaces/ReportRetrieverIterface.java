package com.projectname.project.server.retrofit.interfaces;
import java.util.List;

import com.projectname.project.shared.bean.ReportConfiguration;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReportRetrieverIterface {
	@GET("reports/reportList")
	Call<List<ReportConfiguration>> reportList();
}
