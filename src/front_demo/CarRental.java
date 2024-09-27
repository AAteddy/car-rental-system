package front_demo;

import java.util.Scanner;

public class CarRental {
    private final Scanner scn;
    private CarManager carMgr;
    private CustomerManager customerMgr;

    public CarRental() {
        scn = new Scanner(System.in);
        carMgr = new CarManager();
        customerMgr = new CustomerManager();

        homePage();
    }

    private void homePage() {
        int choice;

        do {
            System.out.println("*** Car Rental Management System ***");
            System.out.println("1. Car Management");
            System.out.println("2. Customer Management");
            System.out.println("0. Exit");
            System.out.println("Enter your Choice: ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    carMgr.manageCar();
                    break;
                case 2:
                    customerMgr.manageCustomer();
                    break;
                case 0:
                    System.out.println("Exiting from system...");
                    break;
                default:
                    System.out.println("Please enter a valid input!");
            }
        } while(choice != 0);
    }

}
