package com.nikiizvorski.sugarandroid.mvp.add;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public interface BookView {
    /**
     * Init data.
     */
    void initData();

    /**
     * Init views.
     */
    void initViews();

    /**
     * Show message.
     *
     * @param message the message
     */
    void showMessage(String message);
}
