package com.projectname.project.client.application;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.Label;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.projectname.project.client.service.WebRetrieverService;
import com.projectname.project.client.service.WebRetrieverServiceAsync;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
	interface Binder extends UiBinder<Widget, ApplicationView> {
	}

	@UiField
	SimplePanel main;
	@UiField
	Label version;
	
	
	@Inject
	ApplicationView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		bindSlot(ApplicationPresenter.SLOT_MAIN, main);
		
		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
		wrService.getRetrieverVersion(new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				version.setText(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Errore durante il caricamento della versione di Report Retriever", caught);
			}
		});
		
		
	}
}