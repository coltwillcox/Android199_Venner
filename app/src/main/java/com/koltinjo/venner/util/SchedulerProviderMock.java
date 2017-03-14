package com.koltinjo.venner.util;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by colt on 05.03.17.
 */

// For use in unit tests. (orig: Immediate)
public class SchedulerProviderMock implements SchedulerProviderBase {

    private static SchedulerProviderMock instance;

    // Private constructor.
    private SchedulerProviderMock() {

    }

    public static synchronized SchedulerProviderMock getInstance() {
        if (instance == null) {
            instance = new SchedulerProviderMock();
        }
        return instance;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }

}
