import java.io.*;
import java.util.Arrays;

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
    static FullTimeStaff[] getInstanceArray(int length) {
        FullTimeStaff[] instanceArray = new FullTimeStaff[length];
        Arrays.fill(instanceArray, new FullTimeStaff());

        return instanceArray;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    FullTimeStaff() {
        this(null, null, null, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    FullTimeStaff(String name, String address, String department, float salary) {
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
    protected void display() {
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
    static PartTimeStaff[] getInstanceArray(int length) {
        PartTimeStaff[] instanceArray = new PartTimeStaff[length];
        Arrays.fill(instanceArray, new PartTimeStaff());

        return instanceArray;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    PartTimeStaff() {
        this(0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    PartTimeStaff(float numberOfHours, float ratePerHour) {
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

            if (ratePerHour <= 0)
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
    protected void display() {
        super.display();
        System.out.println("Number of hours: " + numberOfHours);
        System.out.println("Rate per hour: " + ratePerHour);
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class StaffMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Staff[] groupOfStaff = {};
        Boolean isLoopRunning;
        int menuOption;
        int n = 0;

        while (true) {
            displayMenu();
            isLoopRunning = true;
            while (isLoopRunning) {
                System.out.print("\nEnter menu option: ");
                menuOption = Integer.parseInt(br.readLine());

                switch (menuOption) {
                    case 1:
                        n = getNumberOfStaffInput();
                        groupOfStaff = FullTimeStaff.getInstanceArray(n);
                        isLoopRunning = false;
                        break;
                    case 2:
                        n = getNumberOfStaffInput();
                        groupOfStaff = PartTimeStaff.getInstanceArray(n);
                        isLoopRunning = false;
                        break;
                    case 3:
                        System.out.println("\n>Quitting program...");
                        System.exit(0);
                    default:
                        System.out.println(">Invalid menu option. Enter again.");
                }
            }

            for (int i = 0; i < n; i++)
                groupOfStaff[i].getUserInput();

            System.out.println("\n\n");

            for (int i = 0; i < n; i++)
                groupOfStaff[i].display();
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayMenu() {
        System.out.println("\n----------OBJECT FACTORY MENU-----------");
        System.out.println("1. Full Time Staff");
        System.out.println("2. Part Time Staff");
        System.out.println("3. Quit");
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static int getNumberOfStaffInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter the number of staff: ");
        return Integer.parseInt(br.readLine());
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}