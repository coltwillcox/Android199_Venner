package com.koltinjo.venner.data.auth;

import com.koltinjo.venner.data.DataTestGeneric;
import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by colt on 03.03.17.
 */

public class AuthServiceFake implements AuthSource {

    private boolean returnFailure = false;

    // Constructor.
    public AuthServiceFake() {

    }

    public static AuthSource getInstance() {
        return new AuthServiceFake();
    }

    // Interface methods.
    @Override
    public Completable createAccount(Credentials credentials) {
        if (returnFailure) {
            return Completable.error(new Exception());
        } else {
            return Completable.complete();
        }
    }

    @Override
    public Completable attemptLogin(Credentials credentials) {
        if (returnFailure) {
            return Completable.error(new Exception());
        } else {
            return Completable.complete();
        }
    }

    @Override
    public Completable deleteUser() {
        if (returnFailure) {
            return Completable.error(new Exception());
        } else {
            return Completable.complete();
        }
    }

    @Override
    public Maybe<User> getUser() {
        if (returnFailure) {
            return Maybe.error(new Exception());
        } else {
            return Maybe.just(DataTestGeneric.getUser());
        }
    }

    @Override
    public Completable logUserOut() {
        if (returnFailure) {
            return Completable.error(new Exception());
        } else {
            return Completable.complete();
        }
    }

    @Override
    public Completable reauthenticateUser() {
        if (returnFailure) {
            return Completable.error(new Exception());
        } else {
            return Completable.complete();
        }
    }

    @Override
    public void setReturnFail(boolean bool) {
        returnFailure = bool;
    }

}