package front_demo;

import java.util.Scanner;

public class CustomerManager {
    private final Scanner scn;

    public CustomerManager() {
         scn = new Scanner(System.in);


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
    }

    private void reportCustomer() {
    }
}
