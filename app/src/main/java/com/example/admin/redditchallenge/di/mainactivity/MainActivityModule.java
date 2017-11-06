package com.example.admin.redditchallenge.di.mainactivity;

import com.example.admin.redditchallenge.mvp.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 11/6/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter provideMainActivityPresenter(){return new MainActivityPresenter();}
}
