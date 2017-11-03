package com.projectname.project.client.application.listads;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ListaDataSourceModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(ListaDataSourcePresenter.class, ListaDataSourcePresenter.MyView.class, ListaDataSourceView.class,
				ListaDataSourcePresenter.MyProxy.class);
	}
}
