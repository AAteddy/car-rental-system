package model;

import skeleton_interface.ICustomer;

public class Customer implements ICustomer {
    private String fName;

    public Customer(String name) {
        this.fName = name;
    }

    @Override
    public String getFname() {
        return fName;
    }

    public String toString() {
        return fName;
    }
}