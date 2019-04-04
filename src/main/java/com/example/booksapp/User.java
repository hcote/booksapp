package com.example.booksapp;

import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private java.sql.Date created_at;
    private int wishlist_id;
    private int have_read_list_id;

    public User(int id, String username, String email, String password, Date created_at, int wishlist_id, int have_read_list_id) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.wishlist_id = wishlist_id;
        this.have_read_list_id = have_read_list_id;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getHave_read_list_id() {
        return have_read_list_id;
    }

    public void setHave_read_list_id(int have_read_list_id) {
        this.have_read_list_id = have_read_list_id;
    }

}
