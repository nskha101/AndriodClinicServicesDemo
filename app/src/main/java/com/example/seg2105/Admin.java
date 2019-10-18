package com.example.seg2105;

public class Admin extends User {

    public Admin( String username,String email, String password, String name, String familyName){

        super(username,email,password,name,familyName,  "Admin");

    }

    public Admin(){

    }

}
