package com.nikiizvorski.sugarandroid.di.add;

import com.nikiizvorski.sugarandroid.mvp.add.BookActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
@Singleton
@Component(modules = BookModule.class)
public interface BookComponent {
    /**
     * Inject.
     *
     * @param bookActivity the book activity
     */
    void inject(BookActivity bookActivity);
}
