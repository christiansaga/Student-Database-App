import java.util.Scanner;

//Student class to hold attributes.
public class Student {
    private String firstName;
    private String lastName;
    private String gradeLevel;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 625;
    private static int id = 1000;

    //Constructor prompts user to enter student's name and grade year.
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Student First Name: ");
        this.firstName = in.nextLine();
        this.firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);

        System.out.print("Enter Student Last Name: ");
        this.lastName = in.nextLine();
        this.lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);

        System.out.print("-Freshman\n-Sophomore\n-Junior\n-Senior\nEnter Student Grade Level: ");
        String level = in.nextLine();
        this.gradeLevel = level.substring(0, 1).toUpperCase() + level.substring(1);
        setStudentID();
    }

    //Generate a student ID with it increasing by 1 every student.
    private void setStudentID() {
        //Grade level+ dash + ID
        id++;
        this.studentID = gradeLevel + "-" + "" + id;
    }

    //Method for user to enroll in courses.
    public void enroll() {
        do {
            System.out.print("Enter course to enroll (enter Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if(!course.equalsIgnoreCase("Q")) {
                courses = courses + "\n  " + course.substring(0, 1).toUpperCase() + course.substring(1);
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {
                break;
            }
            //Set a do-while loop with condtion 1 is always not equal to 0. The statement will execute before the loop begins. User is given a chance to enter at least one course before exiting the loop.
        } while (1 != 0);
    }
    //View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    //Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment + ".");
        viewBalance();
        System.out.println("\n");
    }

    //Show status
    public String showInfo() {
        return "Name: " + firstName + " " + lastName + "\nGrade Level: " + gradeLevel + "\nStudentID: " + studentID + "\nCourses Enrolled:" + courses + "\nBalance: $" + tuitionBalance + "\n";
    }
}