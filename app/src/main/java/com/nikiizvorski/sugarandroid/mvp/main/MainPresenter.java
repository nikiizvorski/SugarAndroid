package com.nikiizvorski.sugarandroid.mvp.main;

import android.widget.AdapterView;

import com.nikiizvorski.sugarandroid.sugar.Author;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public interface MainPresenter {

    /**
     * Delete author books.
     *
     * @param author the author
     */
    void deleteAuthorBooks(Author author);

    /**
     * On destroy.
     */
    void onDestroy();

    /**
     * Gets data.
     */
    void getData();

    /**
     * Save author.
     *
     * @param thename the thename
     */
    void saveAuthor(String thename);

    /**
     * Book page.
     */
    void bookPage();

    /**
     * Update author.
     */
    void updateAuthor();

    /**
     * Delete author.
     *
     * @param parent   the parent
     * @param position the position
     */
    void deleteAuthor(AdapterView<?> parent, int position);
}
