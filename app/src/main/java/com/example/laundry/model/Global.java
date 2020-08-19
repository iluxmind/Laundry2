package com.example.laundry.model;


import android.app.Application;

public class Global extends Application {
    private String username;
    private String password;
    private String name;
    private String tel;
    private String address;

    public Global() {
    }

    public Global(String username, String password, String name, String tel, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
