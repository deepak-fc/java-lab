import java.io.*;
import java.util.Arrays;

class Employee {

    static int[] registeredIds = {};
    static int objectCount = 0;

    protected int id;
    protected String name;
    protected String department;
    protected float salary;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static boolean isIdUnique(int idToCheck) {
        for (int preExistingId : registeredIds) {
            if (preExistingId == idToCheck) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Employee() {
        this(-9999, null, null, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Employee(int id, String name, String department, float salary) {
        int newLengthOfRegisteredIds = ++objectCount;
        registeredIds = Arrays.copyOf(registeredIds, newLengthOfRegisteredIds);

        int lastIndex = registeredIds.length - 1;
        registeredIds[lastIndex] = id;

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void display() {
        System.out.println("\n------------DISPLAY EMPLOYEE------------");
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class Manager extends Employee {
    private float bonusPercent;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Manager() {
        this(-9999, null, null, 0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Manager(int id, String name, String department, float salary, float bonusPercent) {
        super(id, name, department, salary);
        this.bonusPercent = bonusPercent;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    void display() {
        super.display();
        System.out.println("Bonus: " + bonusPercent + "%");
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    float getSalaryWithBonus() {
        return salary + (salary * ((float) bonusPercent / 100));
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class EmployeeMain {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Manager[] managers;
        int numberOfManagers = 0;
        float highestSalaryWithBonus = 0;

        System.out.print("\nEnter the number of managers: ");
        numberOfManagers = Integer.parseInt(br.readLine());
        managers = new Manager[numberOfManagers];

        for (int i = 0; i < numberOfManagers; i++)
            managers[i] = getManagerUserInput();

        highestSalaryWithBonus = getHighestSalaryWithBonus(managers);
        displayAllManagersHavingSalary(managers, highestSalaryWithBonus);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static Manager getManagerUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int id;
        String name;
        String department;
        float salary;
        float bonusPercent;

        System.out.println("\n-------------INPUT MANAGER-------------");
        while (true) {
            System.out.print("Enter Employee ID: ");
            id = Integer.parseInt(br.readLine());

            if (id <= 0)
                System.out.println(">Invalid. Enter greater than 0.");
            else if (Manager.isIdUnique(id) == false)
                System.out.println(">Invalid. Already exists.");
            else
                break;
        }

        System.out.print("Enter name: ");
        name = br.readLine();

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

        while (true) {
            System.out.print("Enter bonus percent % : ");
            bonusPercent = Float.parseFloat(br.readLine());

            if (bonusPercent <= 0)
                System.out.println(">Invalid percent. Should be greater than 0.");
            else
                break;
        }
        System.out.println("----------------------------------------\n");

        return new Manager(id, name, department, salary, bonusPercent);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static float getHighestSalaryWithBonus(Manager[] managers) {
        float max = 0;
        for (Manager manager : managers) {
            if (manager.getSalaryWithBonus() > max)
                max = manager.getSalaryWithBonus();
        }
        return max;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayAllManagersHavingSalary(Manager[] managers, float amount) {
        for (Manager manager : managers) {
            if (manager.getSalaryWithBonus() == amount)
                manager.display();
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}