package com.projectname.project.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.projectname.project.client.application.ApplicationModule;
import com.projectname.project.client.place.NameTokens;
import com.projectname.project.client.resources.ResourceLoader;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule
                .Builder()
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();
    }
}
