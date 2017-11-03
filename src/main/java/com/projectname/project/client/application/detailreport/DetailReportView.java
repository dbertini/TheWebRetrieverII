package com.projectname.project.client.application.detailreport;

import java.util.Date;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.DescriptionData;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.projectname.project.client.service.WebRetrieverService;
import com.projectname.project.client.service.WebRetrieverServiceAsync;
import com.projectname.project.shared.bean.ReportConfiguration;

public class DetailReportView extends ViewWithUiHandlers<DetailReportPresenter> implements DetailReportPresenter.MyView {
	
	private String reportName = "";
	
	@UiField
	DescriptionData nomeReport;
	@UiField
	DescriptionData descrizioneReport;
	
	@UiField
	DescriptionData datasourceReport;
	@UiField
	DescriptionData sqlReport;
	@UiField
	DescriptionData schedulazioneReport;
	
	@UiField
	DescriptionData recipitReport;
	@UiField
	DescriptionData ccReport;
	@UiField
	DescriptionData ccnReport;
	@UiField
	Button eseguiButton;
	@UiField
	DescriptionData lastStartTimeReport;
	@UiField
	DescriptionData lastStopTimeReport;
	
	interface Binder extends UiBinder<Widget, DetailReportView> {
	}

	@Inject
	DetailReportView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		GWT.log("Report NAME passato: " + this.reportName);
	}

	@Override
	public void setReportName(String aReportName) {
		this.reportName = aReportName;
		GWT.log("Report NAME passato: " + this.reportName);
		buildData();
	}
	
	
	
	private void buildData() {
		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
		wrService.getReportDetail(this.reportName, new AsyncCallback<ReportConfiguration>() {
			@Override
			public void onSuccess(ReportConfiguration result) {
				nomeReport.setText(result.getName());
				descrizioneReport.setText(result.getDescription());
				datasourceReport.setText(result.getDatasource());
				sqlReport.setText(result.getSql());
				schedulazioneReport.setText(result.getCron());
				recipitReport.setText(result.getRecipient());
				ccReport.setText(result.getCclist());
				ccnReport.setText(result.getCcnlist());
				
				try {
					if(result.getLastStartTime()==0) {
						lastStartTimeReport.setText("");
					} else  {
						Date start = new Date();
						start.setTime(result.getLastStartTime());
						DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
						lastStartTimeReport.setText(fmt.format(start));
					}
				}catch (Exception e) {
					lastStartTimeReport.setText("");
				}

				try {
					if(result.getLastStopTime()==0) {
						lastStopTimeReport.setText("");
					} else {
						Date end = new Date();
						end.setTime(result.getLastStopTime());
						DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
						lastStopTimeReport.setText(fmt.format(end));
					}
				}catch (Exception e) {
					lastStopTimeReport.setText("");
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Errore durante il recupero dei dettagli del report",caught);
			}
		});
	}
	
	@UiHandler("eseguiButton")
	public void onButtonClick(final ClickEvent event) {
		eseguiButton.state().loading();
		WebRetrieverServiceAsync wrService = GWT.create(WebRetrieverService.class);
		wrService.runReport(this.reportName, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Errore durante il lancio del report: ", caught);
				com.google.gwt.user.client.Window.alert("Errore durante il lancio del report: " + caught.getMessage());
				eseguiButton.state().reset();
			}

			@Override
			public void onSuccess(String result) {
				com.google.gwt.user.client.Window.alert("Report eseguito correttamente.");
				eseguiButton.state().reset();
			}
		});
	}
	

}
