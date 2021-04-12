package com.example.imageviewerapp2;

import java.util.ArrayList;

public class Address {

    String name;
    String number;
    String email;


    public void Address(String name, String number, String email){

        this.name = name;
        this.number = number;
        this.email = email;

    }

    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
    public String getEmail(){
        return email;
    }



    public void setName(String name){
        this.name = name;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setEmail(String email){
        this.email=email;
    }


    public static String arrPrint(String name, String number, String email){
        String x,y,z,r;

        x = name;
        y = number;
        z = email;


        r = " [ 이름 : "+x+" / 연락처 : "+y+" / 이메일 : "+z +" ] ";    //출력하기 위한~~

        return r;

    }


}
