package com.projectname.project.client.application.listareport;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.projectname.project.client.application.ApplicationPresenter;
import com.projectname.project.client.place.NameTokens;

public class ListaReportPresenter extends Presenter<ListaReportPresenter.MyView, ListaReportPresenter.MyProxy> {

	interface MyView extends View {
	}

	@ProxyStandard
	@NameToken(NameTokens.LISTA_REPORT)
	interface MyProxy extends ProxyPlace<ListaReportPresenter> {
	}

	@Inject
	ListaReportPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
	}
}
