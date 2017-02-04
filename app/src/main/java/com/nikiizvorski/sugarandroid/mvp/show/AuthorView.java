package com.nikiizvorski.sugarandroid.mvp.show;

import com.nikiizvorski.sugarandroid.sugar.Book;

import java.util.List;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public interface AuthorView {
    /**
     * Init data.
     */
    void initData();

    /**
     * Gets data.
     */
    void getData();

    /**
     * Sets views.
     */
    void setViews();

    /**
     * Delete book.
     */
    void deleteBook();

    /**
     * Update book.
     */
    void updateBook();

    /**
     * Sets adapter.
     *
     * @param kni the kni
     */
    void setAdapter(List<Book> kni);
}
