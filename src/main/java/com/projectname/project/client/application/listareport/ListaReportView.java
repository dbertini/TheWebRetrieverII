package com.projectname.project.client.application.listareport;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.LinkedGroupItem;
import org.gwtbootstrap3.client.ui.ListGroupItem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.projectname.project.client.service.WebRetrieverService;
import com.projectname.project.client.service.WebRetrieverServiceAsync;
import com.projectname.project.shared.bean.ReportConfiguration;

public class ListaReportView extends ViewWithUiHandlers<ListaReportPresenter> implements ListaReportPresenter.MyView {
	
	@UiField
	ListGroupItem listReport;
	
	interface Binder extends UiBinder<Widget, ListaReportView> {
	}

	@Inject
	ListaReportView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
		wrService.getListaReport(new AsyncCallback<ArrayList<ReportConfiguration>>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getMessage());
			}
			@Override
			public void onSuccess(ArrayList<ReportConfiguration> result) {
				buildList(result);
			}
		});
		
	}

	private void buildList(ArrayList<ReportConfiguration> conf) {
		
		
		for (Iterator<ReportConfiguration> iterator = conf.iterator(); iterator.hasNext();) {
			ReportConfiguration report = iterator.next();
			final String name = report.getName();
			
			LinkedGroupItem item = new LinkedGroupItem();
			item.setText("Nome report: " + report.getName() + " - " + report.getDescription());
			
			item.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					getUiHandlers().sendToDetail(name);
				}
			});
			
			listReport.add(item);
		}
		
	}
}
