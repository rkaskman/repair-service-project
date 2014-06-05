package com.ttu.roman.response;


public class CustomerResponseData {
    int id;
    String name;

    public CustomerResponseData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
