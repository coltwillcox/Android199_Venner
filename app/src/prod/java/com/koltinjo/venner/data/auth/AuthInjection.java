package com.koltinjo.venner.data.auth;

/**
 * Created by colt on 05.03.17.
 */

public class AuthInjection {

    public static AuthSource provideAuthSource() {
        return AuthServiceFirebase.getInstance();
    }

}