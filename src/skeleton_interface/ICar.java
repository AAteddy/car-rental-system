package skeleton_interface;

import model.Car;

public interface ICar {

    String getBrand();
    void rentTo(ICustomer c);
    boolean isRented();
    void returnCar();
    ICustomer getRenter();

    static ICar createCar(String brand) {
        return new Car(brand);
    }
}
