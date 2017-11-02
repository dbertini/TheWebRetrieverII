package com.projectname.project.client.application.detailreport;

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
import com.projectname.project.client.application.ApplicationPresenter;
import com.projectname.project.client.place.NameTokens;

public class DetailReportPresenter extends Presenter<DetailReportPresenter.MyView, DetailReportPresenter.MyProxy> implements DetailReportUiHandlers {
	
	PlaceManager placeManager;
	
	private String reportName = "";

	interface MyView extends View, HasUiHandlers<DetailReportPresenter> {
		void setReportName(String aReportName);
	}

	@ProxyStandard
	@NameToken(NameTokens.DETAIL_REPORT)
	interface MyProxy extends ProxyPlace<DetailReportPresenter> {
	}

	@Inject
	DetailReportPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager aPlaceManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		getView().setUiHandlers(this);
		this.placeManager = aPlaceManager;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		this.reportName = request.getParameter("nomereport", "");// esempio di recupero dei parametri
		getView().setReportName(this.reportName);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().setReportName(this.reportName);
	}

	@Override
	protected void onReveal() {
		super.onReveal();
	}

	@Override
	public void sendToListaReport() {
		PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.LISTA_REPORT).build();
		placeManager.revealPlace(placeRequest);
	}
	
}
