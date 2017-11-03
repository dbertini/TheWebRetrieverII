package com.projectname.project.client.application.detailds;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.DescriptionData;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.projectname.project.client.service.WebRetrieverService;
import com.projectname.project.client.service.WebRetrieverServiceAsync;
import com.projectname.project.shared.bean.DataSourceConfiguration;

public class DetailDataSourceView extends ViewWithUiHandlers<DetailDataSourcePresenter> implements DetailDataSourcePresenter.MyView {
	
	private String dataSourceName = "";
	
	@UiField
	DescriptionData nomeDs;
	@UiField
	DescriptionData descrizioneDs;
	@UiField
	DescriptionData usernameDs;
	@UiField
	DescriptionData passwordDs;
	@UiField
	DescriptionData driverDs;

	
	interface Binder extends UiBinder<Widget, DetailDataSourceView> {
	}

	@Inject
	DetailDataSourceView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		GWT.log("DataSource NAME passato: " + this.dataSourceName);
	}

	@Override
	public void setDataSourceName(String aReportName) {
		this.dataSourceName = aReportName;
		GWT.log("DataSource NAME passato: " + this.dataSourceName);
		buildData();
	}
	
	
	
	private void buildData() {
		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
		wrService.getDataSourceDetail(this.dataSourceName, new AsyncCallback<DataSourceConfiguration>() {
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Errore durante il recupero dei dettagli del report",caught);
			}
			@Override
			public void onSuccess(DataSourceConfiguration result) {
				GWT.log(result.toString());
				nomeDs.setText(result.getName());
				descrizioneDs.setText(result.getDescription());
				usernameDs.setText(result.getUsername());
				passwordDs.setText(result.getPassword());
				driverDs.setText(result.getDriver());
			}
		});

	}
	
}
