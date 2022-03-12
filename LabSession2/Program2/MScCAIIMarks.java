package mscca2;

import java.io.*;

public class MScCAIIMarks {

    public int sem1Total;
    public int sem2Total;

    public static int sem1MaxMarks = 600;
    public static int sem2MaxMarks = 600;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public MScCAIIMarks() {
        this(0, 0);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public MScCAIIMarks(int sem1Total, int sem2Total) {
        this.sem1Total = sem1Total;
        this.sem2Total = sem2Total;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public int getTotalMarks() {
        return sem1Total + sem2Total;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // sem 1 marks validation
        while (true) {
            System.out.print("Enter FY.MSc(CA) - Sem(I) total marks: ");
            this.sem1Total = Integer.parseInt(br.readLine());

            if (this.sem1Total < 0 || this.sem1Total > sem1MaxMarks)
                System.out.print(">Invalid. Enter between 0 and " + sem1MaxMarks + "\n");
            else
                break;
        }

        // sem 2 marks validation
        while (true) {
            System.out.print("Enter FY.MSc(CA) - Sem(II) total marks: ");
            this.sem2Total = Integer.parseInt(br.readLine());

            if (this.sem2Total < 0 || this.sem2Total > sem2MaxMarks)
                System.out.print(">Invalid. Enter between 0 and " + sem1MaxMarks + "\n");
            else
                break;
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}