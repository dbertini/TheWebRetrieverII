package com.projectname.project.client.application.detailds;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DetailDataSourceModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(DetailDataSourcePresenter.class, DetailDataSourcePresenter.MyView.class, DetailDataSourceView.class,
				DetailDataSourcePresenter.MyProxy.class);
	}
}
