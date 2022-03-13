import java.io.*;

class Student {

    int rollNumber;
    String name;
    float percentage;

    static int totalCount;
    static int[] rollNumberList;
    static int currentIndex = 0;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Student() {
        this(0, null, 0.0f);
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

            // Bubble sort - descending order
            for (int j = 0; j < studentList.length - 1; j++) {

                if (studentList[j].percentage < studentList[j + 1].percentage) {

                    temp = studentList[j];
                    studentList[j] = studentList[j + 1];
                    studentList[j + 1] = temp;
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

        // roll number validation
        while (true) {
            System.out.print("Enter roll number: ");
            this.rollNumber = Integer.parseInt(br.readLine());

            if (rollNumber <= 0) {
                System.out.println(">Invalid. Enter greater than 0.");
            } else if (!isRollnumberUnique(this.rollNumber)) {
                System.out.println(">Invalid. Already exists.");
            
            // adds unique roll nums to list    
            } else {
                Student.rollNumberList[Student.currentIndex] = this.rollNumber;
                currentIndex++;
                break;
            }
        }

        // name input
        System.out.print("Enter name: ");
        this.name = br.readLine();

        // percentage validation
        while (true) {
            System.out.print("Enter percentage: ");
            this.percentage = Float.parseFloat(br.readLine());

            if (percentage <= 0)
                System.out.println(">Invalid. Should be greater than 0.");
            else
                break;
        }
        System.out.println();
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static boolean isRollnumberUnique(int rollNumber) {
        for (int i = 0; i < Student.totalCount; i++) {
            if (rollNumber == Student.rollNumberList[i]) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return name + "\t" + rollNumber + "\t" + percentage;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class StudentMain {
    public static void main(String[] args) throws IOException {

        int n;
        Student[] studentList;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter the number of students: ");
        n = Integer.parseInt(br.readLine());

        // static variables init
        Student.totalCount = n;
        Student.rollNumberList = new int[n];
    
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
}