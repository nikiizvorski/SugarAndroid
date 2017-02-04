package com.nikiizvorski.sugarandroid.di.main;

import com.nikiizvorski.sugarandroid.mvp.main.MainPresenter;
import com.nikiizvorski.sugarandroid.mvp.main.MainPresenterImpl;
import com.nikiizvorski.sugarandroid.mvp.main.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
@Module
public class MainModule {
    private MainView mainView;

    /**
     * Instantiates a new Main module.
     *
     * @param mainView the main view
     */
    public MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * Gets main view.
     *
     * @return the main view
     */
    @Singleton
    @Provides
    MainView getMainView() {
        return mainView;
    }

    /**
     * Main presenter main presenter.
     *
     * @param mainView the main view
     * @return the main presenter
     */
    @Singleton
    @Provides
    MainPresenter mainPresenter(MainView mainView){
        return new MainPresenterImpl(mainView);
    }
}
