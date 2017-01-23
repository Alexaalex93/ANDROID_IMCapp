package com.example.alex.imcapp;

/**
 * Created by Alex on 23/01/2017.
 */

public class Credentials {
    private String mPassword;
    private String mEmail;

    public Credentials(String email, String password){

        mEmail = email;
        mPassword = password;

    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
