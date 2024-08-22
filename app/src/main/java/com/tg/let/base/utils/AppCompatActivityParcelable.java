package com.tg.let.base.utils;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Contract;

public class AppCompatActivityParcelable implements Parcelable {
    private final Class activityData;

    public AppCompatActivityParcelable(Class activityData) {
        this.activityData = activityData;
    }

    public AppCompatActivityParcelable(@NonNull Parcel in) {
        activityData = (Class) in.readValue(AppCompatActivity.class.getClassLoader());
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeValue(activityData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Class getActivityData() {
        return activityData;
    }

    public static final Creator<AppCompatActivityParcelable> CREATOR = new Creator<AppCompatActivityParcelable>() {
        @NonNull
        @Contract(value = "_ -> new", pure = true)
        @Override
        public AppCompatActivityParcelable createFromParcel(Parcel in) {
            return new AppCompatActivityParcelable(in);
        }

        @NonNull
        @Contract(value = "_ -> new", pure = true)
        @Override
        public AppCompatActivityParcelable[] newArray(int size) {
            return new AppCompatActivityParcelable[size];
        }
    };
}
