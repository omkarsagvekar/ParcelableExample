package com.example.parcelableexample;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ExampleItem {
    private Drawable imageView;
    private String line1, line2;

    public ExampleItem(Drawable imageView, String line1, String line2) {
        this.imageView = imageView;
        this.line1 = line1;
        this.line2 = line2;
    }

    public Drawable getImageView() {
        return imageView;
    }

    public void setImageView(Drawable imageView) {
        this.imageView = imageView;
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
}
