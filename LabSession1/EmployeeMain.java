import java.io.*;

class Employee {

    String name;
    String position;
    float salary;

    static int objectCount = 0;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Employee() {
        this(null, null, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Employee(String name, String position, float salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;

    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return name + "\t" + position + "\t" + salary;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////

}

class EmployeeMain {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Employee[] groupOfEmployees;
        String name, designation;
        float salary;
        int n;

        System.out.print("\nEnter the number of employees: ");
        n = Integer.parseInt(br.readLine());

        groupOfEmployees = new Employee[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\n-------INPUT DETAILS-------");
            System.out.print("Enter name: ");
            name = br.readLine();
            System.out.print("Enter designation: ");
            designation = br.readLine();

            // salary validation
            while (true) {
                System.out.print("Enter salary: ");
                salary = Float.parseFloat(br.readLine());

                if (salary <= 0)
                    System.out.println(">Invalid amount. Should be greater than 0.");
                else
                    break;
            }

            groupOfEmployees[i] = new Employee(name, designation, salary);
            Employee.objectCount++;
            System.out.println("\n[Object Created] Object count: " + Employee.objectCount);

        }

        // Displays all employees
        System.out.println("\n\n");
        for (int i = 0; i < n; i++)
            System.out.println(groupOfEmployees[i]);
    }
}