import java.io.*;

class Vehicle {
    String company;
    float price;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Vehicle() {
        this("", 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Vehicle(String company, float price) {
        this.company = company;
        this.price = price;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void display() {
        System.out.println("\n-------------VEHICLE DISPLAY------------");
        System.out.println("Company: " + company);
        System.out.println("Price: Rs." + price);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n--------------VEHICLE INPUT-------------");
        System.out.print("Enter Company Name: ");
        company = br.readLine();

        while (true) {
            System.out.print("Enter Price: ");
            price = Float.parseFloat(br.readLine());

            if (price <= 0)
                System.out.println(">Invalid amount. Should be greater than 0.");
            else
                break;
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class LightMotorVehicle extends Vehicle {
    float mileage;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    LightMotorVehicle() {
        this("", 0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    LightMotorVehicle(String company, float price, float mileage) {
        super(company, price);
        this.mileage = mileage;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        super.getUserInput();
        while (true) {
            System.out.print("Enter Mileage: ");
            mileage = Float.parseFloat(br.readLine());

            if (mileage <= 0)
                System.out.println(">Invalid value. Mileage Should be greater than 0.");
            else
                break;
        }
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    void display() {
        super.display();
        System.out.println("Mileage: " + mileage);
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class HeavyMotorVehicle extends Vehicle {
    float capacityInTons;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    HeavyMotorVehicle() {
        this("", 0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    HeavyMotorVehicle(String company, float price, float capacityInTons) {
        super(company, price);
        this.capacityInTons = capacityInTons;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        super.getUserInput();
        while (true) {
            System.out.print("Enter Capacity in Tons: ");
            capacityInTons = Float.parseFloat(br.readLine());

            if (capacityInTons <= 0)
                System.out.println(">Invalid value. Capacity Should be greater than 0.");
            else
                break;
        }
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    void display() {
        super.display();
        System.out.println("Capacity in Tons: " + capacityInTons);
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class MotorVehicleMain {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vehicle[] vehicles;
        int menuOption;
        int n;

        System.out.print("\nEnter number of vehicles: ");
        n = Integer.parseInt(br.readLine());

        vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            displayVehicleTypeMenu();
            System.out.print("\nEnter menu option: ");
            menuOption = Integer.parseInt(br.readLine());

            switch (menuOption) {
                case 1:
                    vehicles[i] = new LightMotorVehicle();
                    vehicles[i].getUserInput();
                    break;
                case 2:
                    vehicles[i] = new HeavyMotorVehicle();
                    vehicles[i].getUserInput();
                    break;
                case 3:
                    System.out.println(">Exiting program...");
                    System.exit(0);
                default:
                    System.out.println(">Invalid option. Please enter again.");
                    i--;
            }
        }

        System.out.println("\n\n");
        for (Vehicle v : vehicles)
            v.display();
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayVehicleTypeMenu() {
        System.out.println("\n-----------CHOOSE VEHICLE TYPE-----------");
        System.out.println("1. Light Motor Vehicle");
        System.out.println("2. Heavy Motor Vehicle");
        System.out.println("3. Exit Program");
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}
