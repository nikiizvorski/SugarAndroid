package com.nikiizvorski.sugarandroid.di.main;

import com.nikiizvorski.sugarandroid.mvp.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    /**
     * Inject.
     *
     * @param mainActivity the main activity
     */
    void inject(MainActivity mainActivity);
}
