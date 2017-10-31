package com.projectname.project.client.application.listareport;

import java.util.ArrayList;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.projectname.project.client.application.ApplicationPresenter;
import com.projectname.project.client.place.NameTokens;

public class ListaReportPresenter extends Presenter<ListaReportPresenter.MyView, ListaReportPresenter.MyProxy> {

	interface MyView extends View {
		public void setDefault(String aValue);
		public void addText(String aValue);
		public void buildList(ArrayList<Report> conf);
	}

	@ProxyStandard
	@NameToken(NameTokens.LISTA_REPORT)
	interface MyProxy extends ProxyPlace<ListaReportPresenter> {
	}

	@Inject
	ListaReportPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		String param = request.getParameter("nomereport", "");// esempio di recupero dei parametri
		System.out.println(param);
		getView().setDefault(param);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReveal() {
//		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
//		wrService.getListaReport(new AsyncCallback<List<ReportConfiguration>>() {
//			
//			@Override
//			public void onSuccess(List<ReportConfiguration> result) {
//				ArrayList<Report> repos = new ArrayList<>();
//				
//				result.forEach(a -> {
//					Report rep = new Report();
//					rep.setName(a.getName());
//					
//					repos.add(rep);
//				});
//				
//				getView().buildList(repos);
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//			}
//		});
	}
}
