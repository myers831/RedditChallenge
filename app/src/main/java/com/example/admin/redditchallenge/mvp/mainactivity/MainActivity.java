package com.example.admin.redditchallenge.mvp.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.admin.redditchallenge.di.mainactivity.DaggerMainActivityComponent;
import com.example.admin.redditchallenge.mvp.main2activity.Main2Activity;
import com.example.admin.redditchallenge.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContractor.View {

    EditText etSearch;

    @Inject
    MainActivityPresenter presenter;

    public static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);

        DaggerMainActivityComponent.create().inject(this);
        presenter.addView(this);
    }

    public void search(View view) {
        presenter.callView();
    }

    @Override
    public void showError(String s) {
        Log.d(TAG, "showError: " + s);
    }

    @Override
    public void sendIntent() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("search", etSearch.getText().toString());
        startActivity(intent);
    }
}
