package com.koltinjo.venner.login;

import com.koltinjo.venner.data.auth.AuthSource;
import com.koltinjo.venner.util.SchedulerProviderBase;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by colt on 02.03.17.
 */

public class PresenterLogin implements ContractLogin.Presenter {

    private AuthSource authSource;
    private ContractLogin.View view;
    private CompositeDisposable compositeDisposable;
    private SchedulerProviderBase schedulerProvider;

    // Constructor.
    public PresenterLogin(AuthSource authSource, ContractLogin.View view, SchedulerProviderBase schedulerProvider) {
        this.authSource = authSource;
        this.view = view;
        this.schedulerProvider = schedulerProvider;
        compositeDisposable = new CompositeDisposable();
    }

    // Interface methods.
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onLogInClick() {

    }

    @Override
    public void onCreateClick() {

    }

}