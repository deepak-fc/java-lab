import java.io.*;

import MScCAI.MScCAIMarks;
import MScCAII.MScCAIIMarks;

class Student {

    int rollNumber;
    String name;

    MScCAIMarks firstYearData;
    MScCAIIMarks secondYearData;

    static int totalCount;
    static int[] rollNumbers;
    static int currentIndex = 0;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Student() {
        this(0, null, 0, 0, 0, 0);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Student(int rollNumber, String name, int firstYearSem1Marks, int firstYearSem2Marks, int secondYearSem1Marks,
            int secondYearSem2Marks) {

        this.rollNumber = rollNumber;
        this.name = name;
        firstYearData = new MScCAIMarks(firstYearSem1Marks, firstYearSem2Marks);
        secondYearData = new MScCAIIMarks(secondYearSem1Marks, secondYearSem2Marks);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n------------------INPUT DETAILS-------------------");

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

        // marks input
        firstYearData.getUserInput();
        secondYearData.getUserInput();
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
    public void displayResult() {

        int firstYearMaxMarks = MScCAIMarks.sem1MaxMarks + MScCAIMarks.sem2MaxMarks;
        int secondYearMaxMarks = MScCAIIMarks.sem1MaxMarks + MScCAIIMarks.sem2MaxMarks;

        int totalMaxMarks = firstYearMaxMarks + secondYearMaxMarks;

        float overallPercentage = ((firstYearData.obtainedAnnualMarks() + secondYearData.obtainedAnnualMarks())
                / ((float) totalMaxMarks)) * 100;
        String grade;

        if (overallPercentage >= 70)
            grade = "A";
        else if (overallPercentage >= 60)
            grade = "B";
        else if (overallPercentage >= 50)
            grade = "C";
        else if (overallPercentage >= 40)
            grade = "PASS";
        else
            grade = "FAIL";

        System.out.println("\n------------------DISPLAY RESULT------------------");
        System.out.println("> Name: " + name);
        System.out.println("> Roll Number: " + rollNumber);
        System.out.println("\n> FY. MSc(CA) SEM 1: " + firstYearData.sem1Total + "/" + MScCAIMarks.sem1MaxMarks);
        System.out.println("> FY. MSc(CA) SEM 2: " + firstYearData.sem2Total + "/" + MScCAIMarks.sem2MaxMarks);
        System.out.println("> Total: " + firstYearData.obtainedAnnualMarks() + "/" + firstYearMaxMarks);

        System.out
                .println("\n> SY. MSc(CA) SEM 1 total: " + secondYearData.sem1Total + "/" + MScCAIIMarks.sem1MaxMarks);
        System.out.println("> SY. MSc(CA) SEM 2 total: " + secondYearData.sem2Total + "/" + MScCAIIMarks.sem2MaxMarks);
        System.out.println("> Total: " + secondYearData.obtainedAnnualMarks() + "/" + secondYearMaxMarks);

        System.out.println("\n> Overall total: "
                + (firstYearData.obtainedAnnualMarks() + secondYearData.obtainedAnnualMarks()) + "/" + totalMaxMarks);
        System.out.println("\n> Percentage : " + String.format("%.2f", overallPercentage) + "%" + "\tGrade: " + grade);
        System.out.println("--------------------------------------------------");
    }
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
        for (int i = 0; i < n; i++)
            groupOfStudents[i].displayResult();
    }
}