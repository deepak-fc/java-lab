import java.io.*;

class Student {

    int rollNumber;
    String name;
    float percentage;

    // max size of students as 100
    final static int totalCount = 100;
    static int[] rollNumberList = new int[totalCount];
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

        // roll number validation
        while (true) {
            System.out.print("Enter roll number: ");
            this.rollNumber = Integer.parseInt(br.readLine());

            if (rollNumber <= 0) {
                System.out.println("\n[ROLL NUMBER SHOULD BE GREATER THAN 0][ENTER AGAIN]");
            } else if (!isRollnumberUnique(this.rollNumber)) {
                System.out.println("\n[ROLL NUMBER ALREADY EXISTS][ENTER AGAIN]");
            } else {
                // adds unique roll nums to list
                Student.rollNumberList[Student.currentIndex] = this.rollNumber;
                currentIndex++;
                break;
            }
        }

        System.out.print("Enter name: ");
        this.name = br.readLine();

        // percentage validation
        while (true) {
            System.out.print("Enter percentage: ");
            this.percentage = Float.parseFloat(br.readLine());

            if (percentage <= 0)
                System.out.println("\n[PERCENTAGE SHOULD BE GREATER THAN 0][ENTER AGAIN]");
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
}
