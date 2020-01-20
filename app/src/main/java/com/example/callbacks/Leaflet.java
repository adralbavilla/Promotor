package com.example.callbacks;

import android.widget.ImageView;

public class Leaflet {
    private String group;
    private String date;
    private ImageView image;
    private String estatus;

    public Leaflet(String group, String date) {
        this.group = group;
        this.date = date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
