package com.nikiizvorski.sugarandroid.mvp.add;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public interface BookPresenter {

    /**
     * Add book.
     *
     * @param thename     the thename
     * @param booknamed   the booknamed
     * @param bookSummary the book summary
     */
    void addBook(String thename, String booknamed, String bookSummary);

    /**
     * Check book.
     *
     * @param thename     the thename
     * @param booknamed   the booknamed
     * @param bookSummary the book summary
     */
    void checkBook(String thename, String booknamed, String bookSummary);

    /**
     * On destroy.
     */
    void onDestroy();
}
