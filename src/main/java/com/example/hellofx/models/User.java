package com.example.hellofx.models;

public class User {
    private int user_id;
    private String full_name;
    private String email;
    private String password;
    private String phone_number;
    private String address;

    public User() {
    }

    public User(int user_id, String full_name, String email, String phone_number, String address) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User(String full_name, String email, String password, String phone_number, String address) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
