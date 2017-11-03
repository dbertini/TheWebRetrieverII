package com.projectname.project.client.application.listareport;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.projectname.project.client.application.ApplicationConstants;
import com.projectname.project.client.application.ApplicationPresenter;
import com.projectname.project.client.place.NameTokens;

public class ListaReportPresenter extends Presenter<ListaReportPresenter.MyView, ListaReportPresenter.MyProxy> implements ListaReportUiHandlers {
	
	PlaceManager placeManager;

	interface MyView extends View, HasUiHandlers<ListaReportPresenter> {
		void rewrite();
	}

	@ProxyStandard
	@NameToken(NameTokens.LISTA_REPORT)
	interface MyProxy extends ProxyPlace<ListaReportPresenter> {
	}

	@Inject
	ListaReportPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager aPlaceManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		getView().setUiHandlers(this);
		this.placeManager = aPlaceManager;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		getView().rewrite();
	}

	@Override
	public void sendToDetail(String aWhere) {
		PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.DETAIL_REPORT).with(ApplicationConstants.NOME_REPORT, aWhere)
				.build();
		placeManager.revealPlace(placeRequest);
	}
}
