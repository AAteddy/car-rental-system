package model;

import exception_handling.InvalidNamingException;
import skeleton_interface.ICar;
import skeleton_interface.ICustomer;

public class Car implements ICar {
    private String brand;
    private ICustomer renter;

    public Car(String brandName) throws InvalidNamingException{
        setBrand(brandName);
    }

    private void setBrand(String brandName) throws InvalidNamingException {
        if (brandName.matches("[a-zA-Z]+"))
            this.brand = brandName;
        else
            throw new InvalidNamingException(brandName + " is invalid brand name");
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void rentTo(ICustomer c) {
        if(c != null)
            renter = c;
    }

    @Override
    public boolean isRented() {
        return (renter != null);
    }

    @Override
    public void returnCar() {
        renter = null;
    }

    @Override
    public ICustomer getRenter() {
        return this.renter;
    }
}
