package com.example.admin.redditchallenge.mvp.mainactivity;

/**
 * Created by Admin on 11/6/2017.
 */

public class MainActivityPresenter implements MainActivityContractor.Presenter {

    MainActivityContractor.View view;

    @Override
    public void addView(MainActivityContractor.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void callView() {
        view.sendIntent();
    }
}
