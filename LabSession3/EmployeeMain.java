import java.io.*;

// Have to add validations to all fields if needed later.
class Employee {

    // lab book says making these private, inheritance won't work properly so
    // declared protected instead.

    protected int id;
    protected String name;
    protected String department;
    protected float salary;

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
        System.out.print("Enter Employee ID: ");
        id = Integer.parseInt(br.readLine());
        System.out.print("Enter name: ");
        name = br.readLine();
        System.out.print("Enter department: ");
        department = br.readLine();
        System.out.print("Enter salary: ");
        salary = Float.parseFloat(br.readLine());
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

    private float bonus;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Manager() {
        this(-9999, null, null, 0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Manager(int id, String name, String department, float salary, float bonus) {

        super(id, name, department, salary);
        this.bonus = bonus;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public float getTotalSalary() {
        return salary + bonus;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        super.getUserInput();
        System.out.print("Enter bonus: ");
        bonus = Float.parseFloat(br.readLine());
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonus);
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class EmployeeMain {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Manager[] listManagers;
        int indexOfMaxSalary = 0;
        int n = 0;
        float maxSalary = 0;

        System.out.print("\nEnter the number of employees: ");
        n = Integer.parseInt(br.readLine());

        listManagers = new Manager[n];

        for (int i = 0; i < n; i++) {

            listManagers[i] = new Manager();
            listManagers[i].getUserInput();

            // records max salary employee while input
            if (listManagers[i].getTotalSalary() > maxSalary) {
                maxSalary = listManagers[i].getTotalSalary();
                indexOfMaxSalary = i;
            }
        }

        // Displays employee with max salary
        listManagers[indexOfMaxSalary].display();
    }
}