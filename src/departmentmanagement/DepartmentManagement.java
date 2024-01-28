package departmentmanagement;

import java.util.Scanner;

public class DepartmentManagement {
Scanner in = new Scanner(System.in);
    private String departmentId;
    private String departmentName, headOfDepartment;
    private Course course;
    private DepartmentManagement next , head;

    public DepartmentManagement() {
    }

    public DepartmentManagement(String departmentId, String departmentName, String headOfDepartment) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headOfDepartment = headOfDepartment;
        this.next = null;
        this.course = null;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void assignCourses() {
        Scanner in = new Scanner(System.in);
        String courseId, courseName;

        DepartmentManagement s = head;
        boolean found = false;

        if (head == null) {
            System.out.print("No Department Available in the System!");
            return;
        }

        System.out.print("Enter Department Id: ");
        String id = in.nextLine();

        while (s != null) {
            if (s.departmentId.equals(id)) {
                found = true;
                break;
            }
            s = s.next;
        }

        if (!found) {
            System.out.print("There is no Department available with id: " + id);
            return;
        } else {
            char addMoreCourses;
            do {
                System.out.print("Enter Course ID: ");
                courseId = in.nextLine();

                System.out.print("Enter Course Name: ");
                courseName = in.nextLine();

                Course newCourse = new Course(courseName, courseId, id);
                if (s.course == null) {
                    s.course = newCourse;
                } else {
                    Course currentCourse = s.course;
                    while (currentCourse.next != null) {
                        currentCourse = currentCourse.next;
                    }
                    currentCourse.next = newCourse;
                }

                System.out.print("Do you want to add more courses? (y/n): ");
                addMoreCourses = in.next().charAt(0);
                in.nextLine();
            } while (addMoreCourses == 'y');
        }

        System.out.println("Courses assigned successfully!");
    }

    public void viewCourses() {
        Scanner in = new Scanner(System.in);

        DepartmentManagement s = head;
        boolean found = false;

        if (head == null) {
            System.out.println("No Department Available in the System!");
            return;
        }

        System.out.print("Enter Department Id: ");
        String id = in.nextLine();

        while (s != null) {
            if (s.departmentId.equals(id)) {
                found = true;
                break;
            }
            s = s.next;
        }

        if (!found) {
            System.out.print("There is no Department available with id: " + id);
            return;
        } else {
            Course currentCourse = s.course;
            if (currentCourse == null) {
                System.out.println("No courses assigned to this department.");
            } else {
                System.out.println("Courses assigned to Department " + s.departmentId + ":");
                while (currentCourse != null) {
                    System.out.println("Course ID: " + currentCourse.getCourseCode() +
                            " Course Name: " + currentCourse.getCourseName());
                    currentCourse = currentCourse.next;
                }
            }
        }
    }
private DepartmentManagement addDepartment (){
        in.nextLine();
        System.out.print("Enter Department ID: ");
        this.setDepartmentId(in.nextLine());
        
        System.out.print("Enter Department Name: ");
        this.setDepartmentName(in.nextLine()); 
        
        System.out.print("Enter Head OF Department: ");
        this.setHeadOfDepartment(in.nextLine());
        
        DepartmentManagement dept = new DepartmentManagement(this.getDepartmentId(),
                this.getDepartmentName(),this.getHeadOfDepartment() );
        if(head == null){
            head = dept;
        }
        else{
            DepartmentManagement s = head;
            while(s.next!=null){
                s=s.next;
            }
            s.next = dept;
        }
        return dept;
    }
    public void removeDepartment() {
        if (head == null) {
            System.out.println("There is no Department Available in The System!");
        } else {
            in.nextLine();
            System.out.print("Enter Department ID: ");
            String id = in.nextLine();

            // department to be removed is at the start
            if (head.getDepartmentId().equals(id)) {
                head = head.next;
                System.out.println("Department removed successfully!");
                return;
            }

            // department to be removed is in b\w or at the end
            DepartmentManagement current = head;
            DepartmentManagement previous = null;

            while (current != null) {
                if (current.getDepartmentId().equals(id)) {

                    previous.next = current.next;
                    System.out.println("Department removed successfully!");
                    return;
                }

                previous = current;
                current = current.next;
            }

            // If the department ID is not found
            System.out.println("Department with ID " + id + " not found!");
        }
    }

    public void viewAllDepartment() {
        DepartmentManagement s = head;
        if (head == null) {
            System.out.println("There is no Department Available in the UMS!");
            return;
        }
        System.out.println("Department ID\t  Department Name\t Department Head");
        while (s != null) {
            System.out.println(s.departmentId + "\t" + s.departmentName + "\t" + s.headOfDepartment);
            s = s.next;
        }
    }

    public void viewSpecificDepartment() {
        in.nextLine();
        System.out.print("Enter the Department ID : ");
        String id = in.nextLine();

        DepartmentManagement s = head;
        boolean departmentFound = false;

        while (s != null) {
            if (s.getDepartmentId().equals(id)) {
                departmentFound = true;

                System.out.println("Department ID: " + s.getDepartmentId() +
                        " Department Name: " + s.getDepartmentName() +
                        " Head Of Department: " + s.getHeadOfDepartment());

                System.out.print("Change Head of Department? (y/n): ");
                char choice = in.next().charAt(0);
                in.nextLine();

                if (choice == 'y') {
                    System.out.print("Enter the new Head of Department: ");
                    s.setHeadOfDepartment(in.nextLine());
                    System.out.println("Head of Department has been changed to " + s.getHeadOfDepartment());
                }
                break;
            }
            s = s.next;
        }

        if (!departmentFound) {
            System.out.println("Department with ID " + id + " not found!");
        }
        System.out.println();
    }

    public void menuDepartment() {
        int choice;
        do {
            System.out.print("1. Add Department\n2. Remove Department\n3. View Specific Department\n4. View All Department\n5. Assign Courses\n6. View Assigned Course\n7. Exit\nEnter your choice: ");

            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                in.next();
            }

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    addDepartment();
                    menuDepartment();
                    break;
                case 2:
                    removeDepartment();
                    menuDepartment();
                    break;
                case 3:
                    viewSpecificDepartment();
                    menuDepartment();
                    break;
                case 4:
                    viewAllDepartment();
                    menuDepartment();
                    break;
                case 5:
                    assignCourses();
                    break;
                case 6:
                    viewCourses();
                    menuDepartment();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
    }
}
