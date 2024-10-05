package skeleton_interface;

import exception_handling.InvalidNamingException;
import model.Customer;

public interface ICustomer {

    String getFname();

    static ICustomer createCust(String name) throws InvalidNamingException {
        return new Customer(name);
    }
}
