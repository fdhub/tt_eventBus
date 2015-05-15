package com.apps.mobile.franco.techtalkproject;

import android.app.Application;
import android.content.Intent;

import com.apps.mobile.franco.techtalkproject.service.BackService;

/**
 * Created by franco on 15/05/2015.
 */
public class EventBusApplication extends Application {

    private BackService service;

    @Override
    public void onCreate() {
        startService(new Intent(this, BackService.class));
        super.onCreate();
    }

}
