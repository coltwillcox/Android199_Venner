package com.koltinjo.venner.util;

import io.reactivex.Scheduler;

/**
 * Created by colt on 05.03.17.
 */

public interface SchedulerProviderBase {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}