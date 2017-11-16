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
	
	@UiField
	Button indietroButton;
	
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
				buildData(result);
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
		wrService.runReport(this.reportName, new AsyncCallback<ReportConfiguration>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Errore durante il lancio del report: ", caught);
				com.google.gwt.user.client.Window.alert("Errore durante il lancio del report: " + caught.getMessage());
				eseguiButton.state().reset();
			}

			@Override
			public void onSuccess(ReportConfiguration result) {
				com.google.gwt.user.client.Window.alert("Report eseguito correttamente.");
				
				buildData(result);
				eseguiButton.state().reset();
			}
		});
	}

	@UiHandler("indietroButton")
	public void onButtonIndietroClick(final ClickEvent event) {
		getUiHandlers().sendToListaReport();
	}

	
	private void buildData(ReportConfiguration aReport) {
		//pulizia dei vecchi dati del form
		cleanFormDate();
		
		nomeReport.setText(aReport.getName());
		descrizioneReport.setText(aReport.getDescription());
		datasourceReport.setText(aReport.getDatasource());
		sqlReport.setText(aReport.getSql());
		schedulazioneReport.setText(aReport.getCron());
		recipitReport.setText(aReport.getRecipient());
		ccReport.setText(aReport.getCclist());
		ccnReport.setText(aReport.getCcnlist());
		
		try {
			if(aReport.getLastStartTime()==0) {
				lastStartTimeReport.setText("");
			} else  {
				Date start = new Date();
				start.setTime(aReport.getLastStartTime());
				DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
				lastStartTimeReport.setText(fmt.format(start));
			}
		}catch (Exception e) {
			lastStartTimeReport.setText("");
		}

		try {
			if(aReport.getLastStopTime()==0) {
				lastStopTimeReport.setText("");
			} else {
				Date end = new Date();
				end.setTime(aReport.getLastStopTime());
				DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
				lastStopTimeReport.setText(fmt.format(end));
			}
		}catch (Exception e) {
			lastStopTimeReport.setText("");
		}
	}
	
	private void cleanFormDate() {
		nomeReport.setText("");
		descrizioneReport.setText("");
		datasourceReport.setText("");
		sqlReport.setText("");
		schedulazioneReport.setText("");
		recipitReport.setText("");
		ccReport.setText("");
		ccnReport.setText("");
		lastStartTimeReport.setText("");
		lastStopTimeReport.setText("");
	}
	
}
