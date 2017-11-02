package com.projectname.project.client.application.detailreport;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DetailReportModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(DetailReportPresenter.class, DetailReportPresenter.MyView.class, DetailReportView.class,
				DetailReportPresenter.MyProxy.class);
	}
}
