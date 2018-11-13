package com.psu.esterby.androiduiandlogin_esterby;

import android.support.annotation.Nullable;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Birthday;  // optional
    private String Phone;  // mobile phone number (optional)
    private String EmailAddress;
    private String Password;

    public UserProfile(String fName,
                       String lName,
                       String UName,
                       @Nullable String Birth,
                       @Nullable String Ph,
                       String Mail,
                       String Pass)
    {
        FirstName = fName;
        LastName = lName;
        UserName = UName;
        Birthday = Birth;
        Phone = Ph;
        EmailAddress = Mail;
        Password = Pass;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
