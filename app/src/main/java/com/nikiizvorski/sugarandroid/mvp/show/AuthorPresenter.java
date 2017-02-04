package com.nikiizvorski.sugarandroid.mvp.show;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public interface AuthorPresenter {

    /**
     * On destroy.
     */
    void onDestroy();

    /**
     * Sets data.
     *
     * @param author_name the author name
     */
    void setData(String author_name);
}
