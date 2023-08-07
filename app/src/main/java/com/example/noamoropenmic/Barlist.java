package com.example.noamoropenmic;

import java.io.Serializable;

public class Barlist implements Serializable {

    private String Image;
    private String Name;
    private String Address;
    private String PhoneNumber;



    public Barlist(String barAddress, String barImage, String barName, String barPhone) {

        Image = barImage;
        Name = barName;
        Address = barAddress;
        PhoneNumber = barPhone;
    }

    public String getImage() {
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
