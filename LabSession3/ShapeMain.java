import java.io.*;

abstract class Shape {
    abstract double calculateArea();
    abstract double calculateVolume();
}

class Sphere extends Shape {
    double radius;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Sphere() {
        this(0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Sphere(double radius) {
        this.radius = radius;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n------------SPHERE INPUT--------------");

        while (true) {
            System.out.print("Enter radius(r): ");
            radius = Double.parseDouble(br.readLine());

            if (radius <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else
                break;
        }

        System.out.println("--------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateVolume() {
        return (((double) 4 / 3) * (Math.PI * Math.pow(radius, 3)));
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class Cone extends Shape {
    double radius;
    double height;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Cone() {
        this(0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n--------------CONE INPUT----------------");
        while (true) {
            System.out.print("Enter radius(r): ");
            radius = Double.parseDouble(br.readLine());

            if (radius <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else
                break;
        }

        while (true) {
            System.out.print("Enter height(h): ");
            height = Double.parseDouble(br.readLine());

            if (height <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else
                break;
        }
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateArea() {
        return Math.PI * radius * (radius + Math.sqrt((height * height) + (radius * radius)));
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * ((double) height / 3);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////

}

class Cylinder extends Shape {
    double radius;
    double height;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Cylinder() {
        this(0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    public void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n------------CYLINDER INPUT--------------");

        while (true) {
            System.out.print("Enter radius(r): ");
            radius = Double.parseDouble(br.readLine());

            if (radius <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else break;
        }

        while (true) {
            System.out.print("Enter height(h): ");
            height = Double.parseDouble(br.readLine());

            if (height <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else break;
        }
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateArea() {
        return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////

}

class Box extends Shape {
    double length;
    double breadth;
    double height;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Box() {
        this(0.0f, 0.0f, 0.0f);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void getUserInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n----------------BOX INPUT---------------");
        while (true) {
            System.out.print("Enter length(l): ");
            length = Double.parseDouble(br.readLine());

            if (length <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else
                break;
        }
        while (true) {
            System.out.print("Enter breadth(b): ");
            breadth = Double.parseDouble(br.readLine());

            if (breadth <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else
                break;
        }
        while (true) {
            System.out.print("Enter height(h): ");
            height = Double.parseDouble(br.readLine());

            if (height <= 0)
                System.out.println(">Invalid input. Should be greater than 0.");
            else
                break;
        }

        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateArea() {
        return (2 * length * breadth) + (2 * length * height) + (2 * breadth * height);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    double calculateVolume() {
        return length * breadth * height;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////

}

class ShapeMain {
    public static void main(String[] args) throws IOException {

        Sphere sphere = new Sphere();
        Cone cone = new Cone();
        Cylinder cylinder = new Cylinder();
        Box box = new Box();

        sphere.getUserInput();
        cone.getUserInput();
        cylinder.getUserInput();
        box.getUserInput();

        System.out.println("\nArea of sphere = " + String.format("%.3f", sphere.calculateArea()) + " unit(2)");
        System.out.println("Volume of sphere = " + String.format("%.3f", sphere.calculateVolume()) + " unit(3)");
        System.out.println("\nArea of cone = " + String.format("%.3f", cone.calculateArea()) + " unit(2)");
        System.out.println("Volume of cone = " + String.format("%.3f", cone.calculateVolume()) + " unit(3)");
        System.out.println("\nArea of cylinder = " + String.format("%.3f", cylinder.calculateArea()) + " unit(2)");
        System.out.println("Volume of cylinder = " + String.format("%.3f", cylinder.calculateVolume()) + " unit(3)");
        System.out.println("\nArea of box = " + String.format("%.3f", box.calculateArea()) + " unit(2)");
        System.out.println("Volume of box = " + String.format("%.3f", box.calculateVolume()) + " unit(3)\n");
    }
}