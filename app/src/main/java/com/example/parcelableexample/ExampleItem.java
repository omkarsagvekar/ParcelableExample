package com.example.parcelableexample;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

public class ExampleItem implements Parcelable {
    private int imageResourceId;
    private String line1, line2;

    public ExampleItem(int imageResourceId, String line1, String line2) {
        this.imageResourceId = imageResourceId;
        this.line1 = line1;
        this.line2 = line2;
    }

    protected ExampleItem(Parcel in) {
        imageResourceId = in.readInt();
        line1 = in.readString();
        line2 = in.readString();
    }

    public static final Creator<ExampleItem> CREATOR = new Creator<ExampleItem>() {
        @Override
        public ExampleItem createFromParcel(Parcel in) {
            return new ExampleItem(in);
        }

        @Override
        public ExampleItem[] newArray(int size) {
            return new ExampleItem[size];
        }
    };

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageResourceId);
        parcel.writeString(line1);
        parcel.writeString(line2);
    }
}
