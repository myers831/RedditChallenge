package com.example.admin.redditchallenge.di.main2activity;

import com.example.admin.redditchallenge.mvp.main2activity.Main2ActivityPresenter;
import com.example.admin.redditchallenge.mvp.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 11/6/2017.
 */

@Module
public class Main2ActivityModule {

    @Provides
    Main2ActivityPresenter provideMain2ActivityPresenter(){return new Main2ActivityPresenter();}
}