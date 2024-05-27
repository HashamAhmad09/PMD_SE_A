package com.example.myapplication.ClassActivityFirebase;

import android.graphics.Bitmap;

public class MobileModel {
    public String name,company,Price;
    Bitmap MobileImage;

    public Bitmap getMobileImage() {
        return MobileImage;
    }

    public void setMobileImage(Bitmap mobileImage) {
        MobileImage = mobileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


}
