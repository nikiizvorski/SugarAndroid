package com.nikiizvorski.sugarandroid.di.show;

import com.nikiizvorski.sugarandroid.mvp.show.AuthorActivty;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
@Singleton
@Component(modules = AuthorModule.class)
public interface AuthorComponent {
    /**
     * Inject.
     *
     * @param authorActivty the author activty
     */
    void inject(AuthorActivty authorActivty);
}
