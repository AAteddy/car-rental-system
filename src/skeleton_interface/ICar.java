package skeleton_interface;

public interface ICar {

    String getBrand();
    void rentTo(ICustomer c);
    boolean isRented();
    void returnCar();
    ICustomer getRenter();
}
