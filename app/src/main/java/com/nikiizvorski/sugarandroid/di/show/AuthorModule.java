package com.nikiizvorski.sugarandroid.di.show;

import com.nikiizvorski.sugarandroid.mvp.show.AuthorPresenter;
import com.nikiizvorski.sugarandroid.mvp.show.AuthorPresenterImpl;
import com.nikiizvorski.sugarandroid.mvp.show.AuthorView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
@Module
public class AuthorModule {
    private AuthorView authorView;

    /**
     * Instantiates a new Author module.
     *
     * @param authorView the author view
     */
    public AuthorModule(AuthorView authorView) {
        this.authorView = authorView;
    }

    /**
     * Gets author view.
     *
     * @return the author view
     */
    @Singleton
    @Provides
    AuthorView getAuthorView() {
        return authorView;
    }

    /**
     * Author presenter author presenter.
     *
     * @param authorView the author view
     * @return the author presenter
     */
    @Singleton
    @Provides
    AuthorPresenter authorPresenter(AuthorView authorView){
        return new AuthorPresenterImpl(authorView);
    }
}
