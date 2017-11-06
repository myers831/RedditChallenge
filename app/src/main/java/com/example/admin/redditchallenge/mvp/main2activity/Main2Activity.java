package com.example.admin.redditchallenge.mvp.main2activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.admin.redditchallenge.di.main2activity.DaggerMain2ActivityComponent;
import com.example.admin.redditchallenge.utils.GsonRequest;
import com.example.admin.redditchallenge.R;
import com.example.admin.redditchallenge.utils.RecycleViewAdapter;
import com.example.admin.redditchallenge.model.Child;
import com.example.admin.redditchallenge.model.Reddit;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity implements Main2ActivityContractor.View {

    public static final String TAG = "Main2ActivityTag";
    String BASEURL = "https://www.reddit.com/r/";
    String url;

    RecyclerView rvReddit;
    RecyclerView.LayoutManager layoutManager;
    RecycleViewAdapter adapter;
    String search;

    @Inject
    Main2ActivityContractor.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DaggerMain2ActivityComponent.create().inject(this);
        presenter.addView(this);

        search = getIntent().getStringExtra("search");

        url = BASEURL + search + "/.json";

        rvReddit = findViewById(R.id.rvReddit);
        layoutManager = new LinearLayoutManager(this);
        presenter.makeCall(url);
    }

    @Override
    public void showError(String s) {
        Log.d(TAG, "showError: " + s);
    }

    @Override
    public void setListAdapter(Reddit response) {
        adapter = new RecycleViewAdapter(response.getData().getChildren());
        rvReddit.setLayoutManager(layoutManager);
        rvReddit.setAdapter(adapter);
    }

    @Override
    public void setRequestQueue(GsonRequest<Reddit> gsonRequest) {
        Volley.newRequestQueue(this).add(gsonRequest);
    }
}
