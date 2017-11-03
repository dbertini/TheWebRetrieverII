package com.projectname.project.client.application.listads;

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

public class ListaDataSourcePresenter extends Presenter<ListaDataSourcePresenter.MyView, ListaDataSourcePresenter.MyProxy> implements ListaDataSourceUiHandlers {
	
	PlaceManager placeManager;

	interface MyView extends View, HasUiHandlers<ListaDataSourcePresenter> {
		void rewrite();
	}

	@ProxyStandard
	@NameToken(NameTokens.LISTA_DATASOURCES)
	interface MyProxy extends ProxyPlace<ListaDataSourcePresenter> {
	}

	@Inject
	ListaDataSourcePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager aPlaceManager) {
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
	public void sendToDetail(String aDsName) {
		PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.DETAIL_DATASOURCE).with(ApplicationConstants.NOME_DS, aDsName).build();
		placeManager.revealPlace(placeRequest);
	}
}
