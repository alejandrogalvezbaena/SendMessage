package com.example.usuario.sendmessage.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 29/09/17.
 */

public class Message implements Parcelable {
    private String message;
    private String user;

    public Message(String message, String user) {
        this.message = message;
        this.user = user;
    }

    protected Message(Parcel in) {
        message = in.readString();
        user = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message:" +
                "message='" + message + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (!message.equals(message1.message)) return false;
        return user.equals(message1.user);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(user);
    }
}
