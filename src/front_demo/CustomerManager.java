package front_demo;

import skeleton_interface.ICustomer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    private final Scanner scn;
    private ArrayList<ICustomer> customerRepo;
    //private int custIndex;

    public CustomerManager() {
         scn = new Scanner(System.in);
         customerRepo = new ArrayList<>();
    }

    public void manageCustomer() {
        int choice;

        do {
            System.out.println("*** Customer Management ***");
            System.out.println("1. Add Customer");
            System.out.println("2. Report Customer");
            System.out.println("0. Back");
            System.out.println("Enter your Choice: ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    reportCustomer();
                    break;
                case 0:
                    System.out.println("Back from page");
                    break;
                default:
                    System.out.println("Please enter a valid input!");
            }
        } while (choice != 0);
    }

    private void addCustomer() {
        System.out.println("*** Adding New Customer ***");
        System.out.println("Enter name");
        ICustomer c = null;
        String name = scn.next();
        customerRepo.add(ICustomer.createCust(name));
    }

    public void reportCustomer() {
        int i=1;
        System.out.println("*** Reporting Customers ***");
        System.out.println("No\t\tName");
        for (ICustomer x : customerRepo)
            System.out.println(i++ + "\t\t" + x.getFname());
    }

    public ICustomer getCustomerById(int custmNo) {
        if (custmNo > 0)
            return customerRepo.get(custmNo - 1);
        return null;
    }
}
