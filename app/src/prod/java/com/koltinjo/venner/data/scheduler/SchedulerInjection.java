package com.koltinjo.venner.data.scheduler;

/**
 * Created by colt on 05.03.17.
 */

// Get the real Schedulers.
public class SchedulerInjection {

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProviderProd.getInstance();
    }

}