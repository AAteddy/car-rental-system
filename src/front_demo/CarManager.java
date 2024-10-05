package front_demo;

import skeleton_interface.ICar;
import skeleton_interface.ICustomer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarManager {
    private final Scanner scn;
    private ArrayList<ICar> carsRepo;
    private CustomerManager custMgr;

    public CarManager(CustomerManager customMgr) {
        scn = new Scanner(System.in);
        carsRepo = new ArrayList<>();
        this.custMgr = customMgr;
    }

    public void manageCar() {
        int choice=9;

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
            try {
                choice = scn.nextInt();
            } catch (InputMismatchException ex) {
                scn.next();
                System.err.println("Please enter a valid input number!");
            }
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
        System.out.println("*** Adding New Car ***");
        System.out.println("Enter brand");
        String brand = scn.next();

        carsRepo.add(ICar.createCar(brand));
    }

    private void rentCar() {
        System.out.println("** Renting A Car **");
        reportFreeCars();
        System.out.println("Choose A Car: ");
        int carNo = scn.nextInt();

        custMgr.reportCustomer();
        System.out.println("Choose A Customer: ");
        int custNo = scn.nextInt();
        ICustomer c = custMgr.getCustomerById(custNo);
        carsRepo.get(carNo - 1).rentTo(c);
    }

    private void returnCar() {
        System.out.println("** Returning A Car **");
        reportRentedCars();
        System.out.println("Enter a Car: ");
        int carNo = scn.nextInt();

        carsRepo.get(carNo - 1).returnCar();
    }

    private void reportAllCars() {
        System.out.println("** Reporting All Cars **");
        System.out.println("No\t\tBrand\t\tCustomer");
        for (int j = 0; j < carsRepo.size(); j++) {
            System.out.println((j + 1) + "\t\t" + carsRepo.get(j).getBrand() + "\t\t" + carsRepo.get(j).getRenter());
        }
//        for (ICar x : carsRepo)
//            System.out.println(i++ + "\t\t" + x.getBrand() + "\t\t" + x.getRenter());

    }

    private void reportRentedCars() {
        System.out.println("** Reporting Free Cars **");
        System.out.println("No\t\tBrand\t\tCustomer");
        for (int i = 0; i < carsRepo.size(); i++) {
            if (carsRepo.get(i).isRented())
                System.out.println((i + 1) + "\t\t" + carsRepo.get(i).getBrand() + "\t\t" + carsRepo.get(i).getRenter());
        }
//        for (ICar x : carsRepo)
//            if (x.isRented())
//                System.out.println(i++ + "\t\t" + x.getBrand() + "\t\t" + x.getRenter());

    }

    private void reportFreeCars() {
        System.out.println("** Reporting Free Cars **");
        System.out.println("No\t\tBrand\t\tCustomer");
        for (int i = 0; i < carsRepo.size(); i++) {
            if (!carsRepo.get(i).isRented())
                System.out.println((i + 1) + "\t\t" + carsRepo.get(i).getBrand() + "\t\t" + carsRepo.get(i).getRenter());
        }
    }
}