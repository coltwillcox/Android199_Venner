package com.koltinjo.venner.data.database;

/**
 * Created by colt on 05.03.17.
 */

public class Profile {

    private String biography;
    private String interests;
    private String uid;
    private String email;
    private String photoURL;
    private String name;

    // Constructor.
    public Profile(String biography, String interests, String uid, String email, String photoURL, String name) {
        this.biography = biography;
        this.interests = interests;
        this.uid = uid;
        this.email = email;
        this.photoURL = photoURL;
        this.name = name;
    }

    // Getters and setters.
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}