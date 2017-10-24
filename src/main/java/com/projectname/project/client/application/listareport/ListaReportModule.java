package com.projectname.project.client.application.listareport;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ListaReportModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(ListaReportPresenter.class, ListaReportPresenter.MyView.class, ListaReportView.class,
				ListaReportPresenter.MyProxy.class);
	}
}
