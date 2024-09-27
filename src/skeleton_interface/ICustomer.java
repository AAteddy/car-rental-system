package skeleton_interface;

import model.Customer;

public interface ICustomer {

    String getFname();

    static ICustomer createCust(String name) {
        return new Customer(name);
    }
}
