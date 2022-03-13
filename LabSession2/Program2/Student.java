import java.io.*;

import MScCAI.MScCAIMarks;
import MScCAII.MScCAIIMarks;

public class Student {

    int rollNumber;
    String name;
    MScCAIMarks ca1;
    MScCAIIMarks ca2;

    static int totalCount;
    static int[] rollNumberList;
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
    public Student(int rollNumber, String name, int ca1Sem1Marks, int ca1Sem2Marks, int ca2Sem1Marks,
            int ca2Sem2Marks) {

        this.rollNumber = rollNumber;
        this.name = name;
        ca1 = new MScCAIMarks(ca1Sem1Marks, ca1Sem2Marks);
        ca2 = new MScCAIIMarks(ca2Sem1Marks, ca2Sem2Marks);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n------------------INPUT DETAILS-------------------");

        // roll number validation
        while (true) {
            System.out.print("\nEnter roll number: ");
            this.rollNumber = Integer.parseInt(br.readLine());

            if (rollNumber <= 0) {
                System.out.print(">Invalid. Enter greater than 0.");
            } else if (!isRollnumberUnique(this.rollNumber)) {
                System.out.print(">Invalid. Already exists.");
            
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

        // marks input
        ca1.getUserInput();
        ca2.getUserInput();
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
    public void displayResult() {

        int overallOutOfMarks = (MScCAIMarks.sem1MaxMarks + MScCAIMarks.sem2MaxMarks + MScCAIIMarks.sem1MaxMarks
                + MScCAIIMarks.sem2MaxMarks);
        float percentage = ((float) (ca1.getTotalMarks() + ca2.getTotalMarks()) / overallOutOfMarks) * 100;
        String grade;

        if (percentage >= 70)
            grade = "A";
        else if (percentage >= 60)
            grade = "B";
        else if (percentage >= 50)
            grade = "C";
        else if (percentage >= 40)
            grade = "PASS";
        else
            grade = "FAIL";

        System.out.println("\n------------------DISPLAY RESULT------------------");
        System.out.println("> Name: " + this.name);
        System.out.println("> Roll Number: " + this.rollNumber);
        System.out.println("\n> FY. MSc(CA) SEM 1: " + ca1.sem1Total + "/" + MScCAIMarks.sem1MaxMarks);
        System.out.println("> FY. MSc(CA) SEM 2: " + ca1.sem2Total + "/" + MScCAIMarks.sem2MaxMarks);
        System.out.println(
                "> Total: " + ca1.getTotalMarks() + "/" + (MScCAIMarks.sem1MaxMarks + MScCAIMarks.sem2MaxMarks));

        System.out.println("\n> SY. MSc(CA) SEM 1 total: " + ca2.sem1Total + "/" + MScCAIIMarks.sem1MaxMarks);
        System.out.println("> SY. MSc(CA) SEM 2 total: " + ca2.sem2Total + "/" + MScCAIIMarks.sem2MaxMarks);
        System.out.println(
                "> Total: " + ca2.getTotalMarks() + "/" + (MScCAIIMarks.sem1MaxMarks + MScCAIIMarks.sem2MaxMarks));

        System.out.println(
                "\n> Overall total: " + (ca1.getTotalMarks() + ca2.getTotalMarks()) + "/" + (MScCAIMarks.sem1MaxMarks
                        + MScCAIMarks.sem2MaxMarks + MScCAIIMarks.sem1MaxMarks + MScCAIIMarks.sem2MaxMarks));
        System.out.println("\n> Percentage : " + String.format("%.2f", percentage) + "%" + "\tGrade: " + grade);
        System.out.println("--------------------------------------------------");
    }
}