package com.example.base.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {

    private String name;
    private String accountId;
    private long loginDate;

    public UserInfo() {
    }

    public UserInfo(String name,String accountId,  long loginDate) {
        this.name = name;
        this.accountId = accountId;
        this.loginDate = loginDate;
    }

    public UserInfo(Parcel source) {
        name = source.readString();
        accountId = source.readString();
        loginDate = source.readLong();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(long loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(accountId);
        dest.writeLong(loginDate);
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
