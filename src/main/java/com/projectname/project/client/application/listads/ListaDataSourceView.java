package com.projectname.project.client.application.listads;

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
import com.projectname.project.shared.bean.DataSourceConfiguration;

public class ListaDataSourceView extends ViewWithUiHandlers<ListaDataSourcePresenter> implements ListaDataSourcePresenter.MyView {
	
	@UiField
	ListGroupItem listDataSources;
	
	interface Binder extends UiBinder<Widget, ListaDataSourceView> {
	}

	@Inject
	ListaDataSourceView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void buildList(ArrayList<DataSourceConfiguration> conf) {
		
		if(listDataSources != null) {
			listDataSources.clear();
		}

		for (Iterator<DataSourceConfiguration> iterator = conf.iterator(); iterator.hasNext();) {
			DataSourceConfiguration ds = iterator.next();
			final String name = ds.getName();
			LinkedGroupItem item = new LinkedGroupItem();
			item.setText("Nome report: " + ds.getName() + " - " + ds.getDescription());
			item.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					getUiHandlers().sendToDetail(name);
				}
			});
			listDataSources.add(item);
		}
	}

	@Override
	public void rewrite() {
		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
		wrService.getListaDataSources(new AsyncCallback<ArrayList<DataSourceConfiguration>>() {
			@Override
			public void onFailure(Throwable caught) {
				GWT.log(caught.getMessage());
			}
			@Override
			public void onSuccess(ArrayList<DataSourceConfiguration> result) {
				buildList(result);
			}
		});
	}
	
}
