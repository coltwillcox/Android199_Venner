package com.koltinjo.venner.data.auth;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by colt on 03.03.17.
 */

public class AuthServiceFirebase implements AuthSource {

    // Constructor.
    public AuthServiceFirebase() {

    }

    public static AuthSource getInstance() {
        return new AuthServiceFirebase();
    }

    // Interface methods.
    @Override
    public Completable createAccount(Credentials credentials) {
        return null;
    }

    @Override
    public Completable attemptLogin(Credentials credentials) {
        return null;
    }

    @Override
    public Completable deleteUser() {
        return null;
    }

    @Override
    public Maybe<User> getUser() {
        return null;
    }

    @Override
    public Completable logUserOut() {
        return null;
    }

    @Override
    public Completable reauthenticateUser() {
        return null;
    }

    @Override
    public void setReturnFail(boolean bool) {

    }

}