package com.example.internship_app;



import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Offer {
    private String PostName ,Description,AboutUs;
    public Offer(){

    }
    public  Offer(String PostName,String Description,String AboutUs){
        this.PostName=PostName;
        this.Description=Description;
        this.AboutUs=AboutUs;


    }

    public String getPostName() {
        return PostName;
    }

    public String getDescription() {
        return Description;
    }

    public String getAboutUs() {
        return AboutUs;
    }
}
