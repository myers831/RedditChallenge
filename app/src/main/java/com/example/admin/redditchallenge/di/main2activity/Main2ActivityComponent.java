package com.example.admin.redditchallenge.di.main2activity;

import com.example.admin.redditchallenge.di.mainactivity.MainActivityModule;
import com.example.admin.redditchallenge.mvp.main2activity.Main2Activity;
import com.example.admin.redditchallenge.mvp.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 11/6/2017.
 */

@Component(modules = Main2ActivityModule.class)
public interface Main2ActivityComponent {
    void inject(Main2Activity mainActivity);
}
