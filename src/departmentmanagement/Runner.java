package departmentmanagement;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        admin.setUsername("sharjeel");
        admin.setPassword("0123456");

        boolean loginSuccessful = false;

        do {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                loginSuccessful = true;

                DepartmentManagement department = new DepartmentManagement();
                System.out.println(" 1. Department");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        department.menuDepartment();
                        break;
                    case 2:
                        // Handle courses
                        department.assignCourses();
                        break;
                    case 3:
                        // Handle faculty
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Wrong username or password! Please try again.");
            }
        } while (!loginSuccessful);

        sc.close();
    }
}

