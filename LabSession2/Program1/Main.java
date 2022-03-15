import java.io.*;
import numoperation.PrimeNumber;
import numoperation.PerfectNumber;
import numoperation.ArmStrongNumber;

// To run
// javac Main.java
// java Main

class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number;
        
        System.out.print("\n\nEnter a number to check: ");
        number = Integer.parseInt(br.readLine());

        System.out.println("\n" + number + " is Prime Number: " + PrimeNumber.isPrime(number));
        System.out.println(number + " is Perfect Number: " + PerfectNumber.isPerfect(number));
        System.out.println(number + " is Armstrong Number: " + ArmStrongNumber.isArmstrong(number));
        System.out.println();
    }
}