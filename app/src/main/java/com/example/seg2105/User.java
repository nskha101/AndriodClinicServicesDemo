package com.example.seg2105;

import java.lang.Math;

public class User {

    private String email;
    private String username;
    private String password;
    private String name;
    private String familyName;
    private String role;
    private Clinic clinic;

    public User( String username,String email, String password, String name, String familyName, String role){

        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.familyName = familyName;
        this.role = role;
        this.clinic=null;

    }

    public User( String username,String email, String password, String name, String familyName, String role, Clinic clinic){

        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.familyName = familyName;
        this.role = role;
        this.clinic=clinic;

    }


    public User(){

    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return  email;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getFamilyName(){
        return familyName;
    }

    public String getRole(){
        return role;
    }

    public void setClinic( Clinic clinic){
        this.clinic=clinic;
    }

    public Clinic getClinic(){ return clinic;}


    public void print(){
        System.out.println("Username = "+username+ " password = "+ password + " email = " + email);
    }

    public  String toString(){
        return "Username = "+username+ " password = "+ password + " email = " + email;
    }
}
