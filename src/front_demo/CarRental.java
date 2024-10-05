package front_demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRental {
    private Scanner scn;
    private CarManager carMgr;
    private CustomerManager customerMgr;

    public CarRental() {
        scn = new Scanner(System.in);
        customerMgr = new CustomerManager();
        carMgr = new CarManager(customerMgr);

        homePage();
    }

    private void homePage() {
        int choice = 5;

        do {
            System.out.println("*** Car Rental Management System ***");
            System.out.println("1. Car Management");
            System.out.println("2. Customer Management");
            System.out.println("0. Exit");
            System.out.println("Enter your Choice: ");
            try {
                choice = scn.nextInt();
            } catch (InputMismatchException ex){
                scn.next();
                System.err.println("Please enter a valid input number");
            }
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
