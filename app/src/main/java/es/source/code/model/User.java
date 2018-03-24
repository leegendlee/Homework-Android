package es.source.code.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by leegend on 2018/3/24.
 */

public class User implements Parcelable {
    private String userName;
    private String password;
    private boolean oldUser;

    protected User(Parcel in) {
        userName = in.readString();
        password = in.readString();
        oldUser = in.readByte() != 0;
    }

    public User() {

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOldUser() {
        return oldUser;
    }

    public void setOldUser(boolean oldUser) {
        this.oldUser = oldUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(password);
        parcel.writeByte((byte) (oldUser ? 1 : 0));
    }
}
