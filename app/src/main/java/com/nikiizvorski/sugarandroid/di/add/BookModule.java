package com.nikiizvorski.sugarandroid.di.add;

import com.nikiizvorski.sugarandroid.mvp.add.BookPresenter;
import com.nikiizvorski.sugarandroid.mvp.add.BookPresenterImpl;
import com.nikiizvorski.sugarandroid.mvp.add.BookView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
@Module
public class BookModule {
    private BookView bookView;

    /**
     * Instantiates a new Book module.
     *
     * @param bookView the book view
     */
    public BookModule(BookView bookView) {
        this.bookView = bookView;
    }

    /**
     * Gets book view.
     *
     * @return the book view
     */
    @Singleton
    @Provides
    BookView getBookView() {
        return bookView;
    }

    /**
     * Book presenter book presenter.
     *
     * @param bookView the book view
     * @return the book presenter
     */
    @Singleton
    @Provides
    BookPresenter bookPresenter(BookView bookView){
        return new BookPresenterImpl(bookView);
    }
}
