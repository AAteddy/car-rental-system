package skeleton_interface;

import exception_handling.InvalidNamingException;
import model.Car;

public interface ICar {

    String getBrand();
    void rentTo(ICustomer c);
    boolean isRented();
    void returnCar();
    ICustomer getRenter();

    static ICar createCar(String brand) throws InvalidNamingException {
        return new Car(brand);
    }
}
