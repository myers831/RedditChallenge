package com.example.admin.redditchallenge.mvp.main2activity;


import com.example.admin.redditchallenge.model.Reddit;
import com.example.admin.redditchallenge.mvp.BasePresenter;
import com.example.admin.redditchallenge.mvp.BaseView;
import com.example.admin.redditchallenge.utils.GsonRequest;

/**
 * Created by Admin on 11/6/2017.
 */

public interface Main2ActivityContractor {

    public interface View extends BaseView{
        public void setListAdapter(Reddit response);
        public void setRequestQueue(GsonRequest<Reddit> gsonRequest);
    }

    public interface Presenter extends BasePresenter<View>{
        public void makeCall(String url);
    }
}
