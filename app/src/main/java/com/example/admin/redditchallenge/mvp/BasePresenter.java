package com.example.admin.redditchallenge.mvp;

/**
 * Created by Admin on 11/2/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void addView(V View);
    void removeView();

}
