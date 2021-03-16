package com.example.drsnoopy.Model;

public class SelectModel {
    int Image;
    String Text;

    public SelectModel(int image, String text) {
        Image = image;
        Text = text;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
