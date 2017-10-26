package com.projectname.project.client.application.listareport;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.Button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.user.client.Timer;

public class ListaReportView extends ViewImpl implements ListaReportPresenter.MyView {
	
	@UiField
	Button bottone;
	
	interface Binder extends UiBinder<Widget, ListaReportView> {
	}

	@Inject
	ListaReportView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("bottone")
	public void onButtonClick(final ClickEvent event) {
		bottone.state().loading();

        new Timer() {
            @Override
            public void run() {
            	bottone.state().reset();
            }
        }.schedule(2000);
	}
}
