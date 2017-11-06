package com.example.admin.redditchallenge.mvp.main2activity;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.admin.redditchallenge.model.Child;
import com.example.admin.redditchallenge.model.Reddit;
import com.example.admin.redditchallenge.mvp.mainactivity.MainActivityContractor;
import com.example.admin.redditchallenge.utils.GsonRequest;
import com.example.admin.redditchallenge.utils.RecycleViewAdapter;

/**
 * Created by Admin on 11/6/2017.
 */

public class Main2ActivityPresenter implements Main2ActivityContractor.Presenter {

    Main2ActivityContractor.View view;

    public static final String TAG = "PresenterTag";

    @Override
    public void addView(Main2ActivityContractor.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void makeCall(String url) {
        GsonRequest<Reddit> gsonRequest = new GsonRequest<>
                ( url, Reddit.class, null, new Response.Listener<Reddit>() {
                    @Override
                    public void onResponse(Reddit response) {

                        for(Child c: response.getData().getChildren()){
                            Log.d(TAG, "onResponse: " + c.getData().getTitle());
                        }

                        view.setListAdapter(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d(TAG, "onErrorResponse: " + error);
                    }
                });

        view.setRequestQueue(gsonRequest);
    }
}
