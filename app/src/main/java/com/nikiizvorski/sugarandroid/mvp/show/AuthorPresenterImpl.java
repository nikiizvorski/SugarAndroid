package com.nikiizvorski.sugarandroid.mvp.show;

import com.nikiizvorski.sugarandroid.sugar.Author;
import com.nikiizvorski.sugarandroid.sugar.Book;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public class AuthorPresenterImpl implements AuthorPresenter {
    /**
     * The Author view.
     */
    @Inject AuthorView authorView;

    /**
     * Instantiates a new Author presenter.
     *
     * @param authorView the author view
     */
    @Inject
    public AuthorPresenterImpl(AuthorView authorView) {
        this.authorView = authorView;
    }

    @Override
    public void setData(String author_name) {
        List<Author> authors = Author.listAll(Author.class);
        for (Author avtor : authors){
            if (avtor.getName().matches(author_name)){
                List<Book> kni = avtor.getBooks();
                authorView.setAdapter(kni);
            }
        }
    }

    @Override
    public void onDestroy() {
        authorView = null;
    }
}
