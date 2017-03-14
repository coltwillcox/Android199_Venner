package com.koltinjo.venner.data.auth;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by colt on 05.03.17.
 */

public interface AuthSource {

    Completable createAccount(Credentials credentials);

    Completable attemptLogin(Credentials credentials);

    Completable deleteUser();

    Maybe<User> getUser();

    Completable logUserOut();

    Completable reauthenticateUser();

    void setReturnFail(boolean bool);

}