package front_demo;


import exception_handling.InvalidCustomerNumberException;
import exception_handling.InvalidNamingException;
import skeleton_interface.ICustomer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerManager {
    private final Scanner scn;
    private ArrayList<ICustomer> customerRepo;
    //private int custIndex;

    public CustomerManager() {
         scn = new Scanner(System.in);
         customerRepo = new ArrayList<ICustomer>();
    }

    public void manageCustomer() {
        int choice=5;

        do {
            System.out.println("*** Customer Management ***");
            System.out.println("1. Add Customer");
            System.out.println("2. Report Customer");
            System.out.println("0. Back");
            System.out.println("Enter your Choice: ");
            try {
                choice = scn.nextInt();
            } catch (InputMismatchException ex) {
                scn.next();
                System.err.println("Please enter a valid input number!");
            }

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
        do {
            System.out.println("Enter name");
            String name = scn.next();
            try {
                customerRepo.add(ICustomer.createCust(name));
                break;
            } catch (InvalidNamingException ex) {
                System.err.println(ex.getMessage());
            }
        } while(true);
    }

    public void reportCustomer() {
        System.out.println("*** Reporting Customers ***");
        System.out.println("No\t\tName");
        for (int i = 0; i < customerRepo.size(); i++) {
            System.out.println((i+1) + "\t\t" + customerRepo.get(i).getFname());
        }
//        for (ICustomer x : customerRepo)
//            System.out.println(i++ + "\t\t" + x.getFname());
    }

    public ICustomer getCustomerById(int custmNo) throws InvalidCustomerNumberException{
        if (custmNo < 0 || custmNo > customerRepo.size())
            throw new InvalidCustomerNumberException(custmNo + " is invalid customer number");
        else
            return customerRepo.get(custmNo - 1);
    }
}
