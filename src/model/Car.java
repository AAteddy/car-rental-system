package model;

import skeleton_interface.ICar;
import skeleton_interface.ICustomer;

public class Car implements ICar {
    private String brand;
    private ICustomer renter;

    public Car(String brandName) {
        this.brand = brandName;
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
        return renter;
    }
}
