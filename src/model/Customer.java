package model;

import exception_handling.InvalidNamingException;
import skeleton_interface.ICustomer;

public class Customer implements ICustomer {
    private String fName;

    public Customer(String name) throws InvalidNamingException{
        setName(name);
    }

    private void setName(String name) throws InvalidNamingException{
        if (name.matches("[a-zA-Z]+"))
            this.fName = name;
        else
            throw new InvalidNamingException(name + " is invalid first name");
    }

    @Override
    public String getFname() {
        return fName;
    }

    public String toString() {
        return fName;
    }
}