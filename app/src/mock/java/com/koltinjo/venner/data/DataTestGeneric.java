package com.koltinjo.venner.data;

import com.koltinjo.venner.data.auth.Credentials;
import com.koltinjo.venner.data.auth.User;
import com.koltinjo.venner.data.database.Profile;

/**
 * Created by colt on 05.03.17.
 */

public class DataTestGeneric {

    public static String getValidEmail() {
        return "derp@example.com";
    }

    public static String getInvalidEmail() {
        return "derpatexample.com";
    }

    public static String getName() {
        return "Derp";
    }

    public static String getValidPassword() {
        return "123456";
    }

    public static String getInvalidPassword() {
        return "12345";
    }

    public static User getUser() {
        return new User("derp@example.com", "someUid9");
    }

    public static Credentials getCredentials() {
        return new Credentials("123456", "derp@example.com", "123456");
    }

    public static String getPhotoURI() {
        return "derp/example.jpg";
    }

    public static Profile getProfile() {
        return new Profile("", "", "someUid9", "derp@example.com", "", "Derp");
    }

}