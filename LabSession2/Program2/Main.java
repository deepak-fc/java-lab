import java.io.*;

// Run commands
// javac -d . MScCAIMarks.java
// javac -d . MScCAIIMarks.java
// javac Main.java
// java Main

class Main {
    public static void main(String[] args) throws IOException {

        int n;
        Student[] studentList;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter the number of students: ");
        n = Integer.parseInt(br.readLine());

        studentList = new Student[n];

        for (int i = 0; i < n; i++) {
            studentList[i] = new Student();
            studentList[i].getUserInput();
        }
        for (int i = 0; i < n; i++) {
            studentList[i].displayResult();
        }
    }
}