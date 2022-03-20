import java.io.*;

class Employee {

    protected int id;
    protected String name;
    protected String department;
    protected float salary;

    static int[] registeredIds;
    static int totalCount;
    static int currentIndex = 0;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Employee() {
        this(-9999, null, null, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Employee(int id, String name, String department, float salary) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n-------------INPUT EMPLOYEE-------------");

        while (true) {
            System.out.print("Enter Employee ID: ");
            id = Integer.parseInt(br.readLine());

            if (id <= 0) {
                System.out.println(">Invalid. Enter greater than 0.");
            } else if (!isIdUnique(id)) {
                System.out.println(">Invalid. Already exists.");
            } else {
                Employee.registeredIds[Employee.currentIndex] = id;
                currentIndex++;
                break;
            }
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
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static boolean isIdUnique(int id) {
        for (int i = 0; i < Employee.totalCount; i++) {
            if (id == Employee.registeredIds[i]) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void display() {

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
    public Manager() {
        this(-9999, null, null, 0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Manager(int id, String name, String department, float salary, float bonusPercent) {

        super(id, name, department, salary);
        this.bonusPercent = bonusPercent;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public float salaryWithBonus() {
        return salary + (salary * ((float) bonusPercent / 100));
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        super.getUserInput();
        while (true) {
            System.out.print("Enter bonus percent % : ");
            bonusPercent = Float.parseFloat(br.readLine());

            if (bonusPercent <= 0)
                System.out.println(">Invalid percent. Should be greater than 0.");
            else
                break;
        }
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonusPercent + "%");
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class EmployeeMain {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Manager[] groupOfManagers;

        float currentMaxSalary = 0;
        int indexOfMaxSalary = 0;
        int n = 0;

        System.out.print("\nEnter the number of managers: ");
        n = Integer.parseInt(br.readLine());

        groupOfManagers = new Manager[n];

        // static variables init
        Employee.totalCount = n;
        Employee.registeredIds = new int[n];

        for (int i = 0; i < n; i++) {

            groupOfManagers[i] = new Manager();
            groupOfManagers[i].getUserInput();

            // records max salaried manager
            if (groupOfManagers[i].salaryWithBonus() > currentMaxSalary) {
                currentMaxSalary = groupOfManagers[i].salaryWithBonus();
                indexOfMaxSalary = i;
            }
        }

        System.out.println("----------MAX SALARIED MANAGER----------");
        groupOfManagers[indexOfMaxSalary].display();
    }
}