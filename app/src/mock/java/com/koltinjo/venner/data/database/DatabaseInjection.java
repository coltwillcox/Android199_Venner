package com.koltinjo.venner.data.database;

/**
 * Created by colt on 14.03.17.
 */

public class DatabaseInjection {

    public static DatabaseSourceFake provideDatabaseSource() {
        return DatabaseSourceFake.getInstance();
    }

}