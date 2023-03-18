package com.example.noamoropenmic;

import java.io.Serializable;

public class Barlist implements Serializable {

    private int Image;
    private String Name;
    private String Address;
    private String PhoneNumber;

    public Barlist(int image, String name, String address, String phoneNumber) {
        Image = image;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public int getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
