package com.projectname.project.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.projectname.project.client.application.detailds.DetailDataSourceModule;
import com.projectname.project.client.application.detailreport.DetailReportModule;
import com.projectname.project.client.application.home.HomeModule;
import com.projectname.project.client.application.listads.ListaDataSourceModule;
import com.projectname.project.client.application.listareport.ListaReportModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new ListaReportModule());
        install(new DetailReportModule());
        install(new ListaDataSourceModule());
        install(new DetailDataSourceModule());
        
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
