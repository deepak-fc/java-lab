import java.io.*;

class Student {

    int rollNumber;
    String name;
    float percentage;

    static int totalCount;
    static int[] rollNumbers;
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
    public static void sortStudents(Student[] groupOfStudents) {

        Student temp;

        while (true) {

            boolean didSwap = false;

            // Bubble sort - descending order
            for (int j = 0; j < groupOfStudents.length - 1; j++) {

                if (groupOfStudents[j].percentage < groupOfStudents[j + 1].percentage) {

                    temp = groupOfStudents[j];
                    groupOfStudents[j] = groupOfStudents[j + 1];
                    groupOfStudents[j + 1] = temp;
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
            } else {
                Student.rollNumbers[Student.currentIndex] = this.rollNumber;
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
            if (rollNumber == Student.rollNumbers[i]) {
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

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Student[] groupOfStudents;
        int n;

        System.out.print("\nEnter the number of students: ");
        n = Integer.parseInt(br.readLine());

        groupOfStudents = new Student[n];

        // static variables init
        Student.totalCount = n;
        Student.rollNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            groupOfStudents[i] = new Student();
            groupOfStudents[i].getUserInput();
        }

        System.out.println("\n---------Before sorting--------");
        for (int i = 0; i < n; i++)
            System.out.println(groupOfStudents[i]);

        Student.sortStudents(groupOfStudents);

        System.out.println("\n---------After sorting---------");
        for (int i = 0; i < n; i++)
            System.out.println(groupOfStudents[i]);
    }
}