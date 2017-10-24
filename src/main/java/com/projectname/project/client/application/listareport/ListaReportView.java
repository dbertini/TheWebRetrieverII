package com.projectname.project.client.application.listareport;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ListaReportView extends ViewImpl implements ListaReportPresenter.MyView {
	interface Binder extends UiBinder<Widget, ListaReportView> {
	}

	@Inject
	ListaReportView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
