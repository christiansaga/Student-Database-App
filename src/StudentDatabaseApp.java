import java.util.Scanner;
import java.util.InputMismatchException;

class StudentDatabaseApp {
    public static void main(String[] args) {
        //Declare 0 number of students and create an array called students equaling an initial null amount.
        Scanner in = new Scanner(System.in);
        int numOfStudents = 0;
        Student [] students = null;
        //Ask how many new students we want to add
        try {
            System.out.print("Enter number of new students to enroll: ");
            numOfStudents = in.nextInt();
            students = new Student[numOfStudents];
        }
        //Just in case user does not type in a number.
        catch(InputMismatchException ex) {
            System.out.println("Please enter a numerical number. Rerun program again.");
            in.nextLine();
        }

        //Create n number of new students
        for(int n = 0; n < numOfStudents; n++) {
            //Loops through n amount of students and calls methods below n number of times.
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
            System.out.println(students[n].showInfo());
        }
        //Display all of the enrolled students in management system.
        System.out.println("\nList of Enrolled Students:\n");
        for(int n = 0; n < numOfStudents; n++) {
            System.out.println(students[n].showInfo());
        }
    }
}