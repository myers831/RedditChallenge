package com.example.admin.redditchallenge.di.mainactivity;

import com.example.admin.redditchallenge.mvp.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 11/6/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
