package front_demo;

import java.util.Scanner;

public class CarManager {
    private final Scanner scn;

    public CarManager() {
        scn = new Scanner(System.in);


    }

    public void manageCar() {
        int choice;

        do {
            System.out.println("*** Car Management ***");
            System.out.println("1. Add Car");
            System.out.println("2. Rent Car");
            System.out.println("3. Return Car");
            System.out.println("4. Report All Cars");
            System.out.println("5. Report Rented Cars");
            System.out.println("6. Report Free Cars");
            System.out.println("0. Back");
            System.out.println("Enter your Choice: ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    rentCar();
                    break;
                case 3:
                    returnCar();
                    break;
                case 4:
                    reportAllCars();
                    break;
                case 5:
                    reportRentedCars();
                    break;
                case 6:
                    reportFreeCars();
                    break;
                case 0:
                    System.out.println("Back from page");
                    break;
                default:
                    System.out.println("Please enter a valid input!");
            }
        } while (choice != 0);
    }

    private void addCar() {
    }

    private void rentCar() {
    }

    private void returnCar() {
    }

    private void reportAllCars() {
    }

    private void reportRentedCars() {
    }

    private void reportFreeCars() {
    }
}
