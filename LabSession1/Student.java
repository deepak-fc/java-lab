import java.io.*;

public class Student {

    int rollNumber;
    String name;
    float percentage;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Student() {
        this(-9999, "NA", 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Student(int rollNumber, String name, float percentage) {
       
        this.rollNumber = rollNumber;
        this.name = name;
        this.percentage = percentage;
    
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public static void sortStudents(Student[] studentList) {

        Student temp;

        while (true) {
            
            boolean didSwap = false;
            
            // Bubble sort
            for (int j = 0; j < studentList.length - 1; j++) {
                
                if (studentList[j].percentage > studentList[j + 1].percentage) {

                    temp = new Student(studentList[j].rollNumber, studentList[j].name, studentList[j].percentage);
                    studentList[j] = new Student(studentList[j + 1].rollNumber, studentList[j + 1].name, studentList[j + 1].percentage);
                    studentList[j + 1] = new Student(temp.rollNumber, temp.name, temp.percentage);
                    didSwap = true;
                }
            }
            if (!didSwap)
                break;
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n---------INPUT DETAILS---------");

        System.out.print("Enter roll number: ");
        this.rollNumber = Integer.parseInt(br.readLine());

        System.out.print("Enter name: ");
        this.name = br.readLine();

        System.out.print("Enter percentage: ");
        this.percentage = Float.parseFloat(br.readLine());
        System.out.println();
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "\n" + name + "\t" + rollNumber + "\t" + percentage;
    }

    /////////////////////////////////////////////////////////////////////////////
    // Main method to demonstrate class functionality
    /////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {

        int n;
        Student[] studentList;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of students: ");
        n = Integer.parseInt(br.readLine());

        studentList = new Student[n];

        for (int i = 0; i < n; i++) {
            studentList[i] = new Student();
            studentList[i].getUserInput();
        }

        System.out.println("\n---------Before sorting--------");
        for (int i = 0; i < n; i++)
            System.out.println(studentList[i]);

        Student.sortStudents(studentList);

        System.out.println("\n---------After sorting---------");
        for (int i = 0; i < n; i++)
            System.out.println(studentList[i]);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}
