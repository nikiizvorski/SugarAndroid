package com.nikiizvorski.sugarandroid.mvp.main;

import android.widget.AdapterView;

import com.nikiizvorski.sugarandroid.sugar.Author;

import java.util.List;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public interface MainView {
    /**
     * Init data.
     */
    void initData();

    /**
     * Sets views.
     */
    void setViews();

    /**
     * Sets data.
     */
    void setData();

    /**
     * Update author.
     */
    void updateAuthor();

    /**
     * Book page.
     */
    void bookPage();

    /**
     * Show message.
     *
     * @param message the message
     */
    void showMessage(String message);

    /**
     * Sets adapter data.
     *
     * @param books the books
     */
    void setAdapterData(List<Author> books);

    /**
     * Pass changes.
     *
     * @param author the author
     */
    void passChanges(Author author);

    /**
     * Pass data changes.
     *
     * @param position the position
     */
    void passDataChanges(int position);
}
