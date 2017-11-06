package com.example.admin.redditchallenge.mvp.mainactivity;

import com.example.admin.redditchallenge.mvp.BasePresenter;
import com.example.admin.redditchallenge.mvp.BaseView;

/**
 * Created by Admin on 11/6/2017.
 */

public interface MainActivityContractor {

    public interface View extends BaseView{
        public void sendIntent();
    }

    public interface Presenter extends BasePresenter<View>{
        public void callView();
    }

}
