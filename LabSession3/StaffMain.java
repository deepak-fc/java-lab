import java.io.*;

abstract class Staff {

    String name;
    String address;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    protected void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n---------------INPUT STAFF--------------");
        System.out.print("Enter name: ");
        name = br.readLine();
        System.out.print("Enter address: ");
        address = br.readLine();

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    protected void display() {

        System.out.println("\n--------------DISPLAY STAFF-------------");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class FullTimeStaff extends Staff {

    String department;
    float salary;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public FullTimeStaff() {

        this(null, null, null, 0.0f);

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public FullTimeStaff(String name, String address, String department, float salary) {

        this.name = name;
        this.address = address;
        this.department = department;
        this.salary = salary;

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    protected void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        super.getUserInput();
        System.out.print("Enter department: ");
        department = br.readLine();

        while (true) {
            System.out.print("Enter salary: ");
            salary = Float.parseFloat(br.readLine());

            if (salary <= 0)
                System.out.println(">Invalid amount. Should be greater than 0.");
            else
                break;
        }

        System.out.println("----------------------------------------");

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void display() {

        super.display();
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class PartTimeStaff extends Staff {

    float numberOfHours;
    float ratePerHour;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public PartTimeStaff() {

        this(0.0f, 0.0f);

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public PartTimeStaff(float numberOfHours, float ratePerHour) {

        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    protected void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        super.getUserInput();

        while (true) {
            System.out.print("Enter number of hours: ");
            numberOfHours = Float.parseFloat(br.readLine());

            if (numberOfHours <= 0)
                System.out.println(">Invalid hours. Should be greater than 0.");
            else
                break;
        }

        while (true) {
            System.out.print("Enter rate per hour: ");
            ratePerHour = Float.parseFloat(br.readLine());

            if (ratePerHour < 0)
                System.out.println(">Invalid amount. Should be greater than equal to 0.");
            else
                break;
        }

        System.out.println("----------------------------------------");

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void display() {

        super.display();
        System.out.println("Number of hours: " + numberOfHours);
        System.out.println("Rate per hour: " + ratePerHour);
        System.out.println("----------------------------------------");

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

public class StaffMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Staff[] groupOfStaff;
        int n;
        int menuOption;

        System.out.print("\nEnter the number of staff: ");
        n = Integer.parseInt(br.readLine());

        groupOfStaff = new Staff[n];

        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter staff type -> ['1' for Full time] OR ['2' for Part time]: ");
            menuOption = Integer.parseInt(br.readLine());

            switch (menuOption) {
                case 1:
                    groupOfStaff[i] = new FullTimeStaff();
                    groupOfStaff[i].getUserInput();
                    break;
                case 2:
                    groupOfStaff[i] = new PartTimeStaff();
                    groupOfStaff[i].getUserInput();
                    break;
                default:
                    System.out.println(">Invalid menu option. Enter again.");
                    i--;
                    break;
            }
        }

        // displays full time staff
        System.out.println("\n\n-------DISPLAYING FULL TIME STAFF-------");
        for (int i = 0; i < n; i++) {
            if (groupOfStaff[i] instanceof FullTimeStaff)
                groupOfStaff[i].display();
        }

        // displays part time staff
        System.out.println("\n\n-------DISPLAYING PART TIME STAFF-------");
        for (int i = 0; i < n; i++) {
            if (groupOfStaff[i] instanceof PartTimeStaff)
                groupOfStaff[i].display();
        }
    }
}