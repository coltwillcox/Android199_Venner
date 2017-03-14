package com.koltinjo.venner.util;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by colt on 05.03.17.
 */

// For use in production/instrumented tests. (orig: no Prod)
public class SchedulerProviderProd implements SchedulerProviderBase {

    private static SchedulerProviderProd instance;

    // Private constructor.
    private SchedulerProviderProd() {

    }

    private static synchronized SchedulerProviderProd getInstance() {
        if (instance == null) {
            instance = new SchedulerProviderProd();
        }
        return instance;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

}