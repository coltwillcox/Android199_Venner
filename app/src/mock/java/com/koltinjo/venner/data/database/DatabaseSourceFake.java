package com.koltinjo.venner.data.database;

import com.koltinjo.venner.data.DataTestGeneric;
import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by colt on 14.03.17.
 */

public class DatabaseSourceFake implements DatabaseSource {

    boolean returnFailure = false;
    boolean returnEmpty = false;

    public DatabaseSourceFake() {

    }

    public static DatabaseSourceFake getInstance() {
        return new DatabaseSourceFake();
    }

    @Override
    public Completable createProfile(Profile profile) {
        if (returnFailure) {
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Maybe<Profile> getProfile(String uid) {
        if (returnFailure) {
            return Maybe.error(new Exception());
        } else if (returnEmpty) {
            return Maybe.empty();
        }
        return Maybe.just(DataTestGeneric.getProfile());
    }

    @Override
    public Completable deleteProfile(String uid) {
        if (returnFailure) {
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable updateProfile(Profile profile) {
        if (returnFailure) {
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public void setReturnFail(boolean returnFailure) {
        this.returnFailure = returnFailure;
    }

    @Override
    public void setReturnEmpty(boolean returnEmpty) {
        this.returnEmpty = returnEmpty;
    }

}