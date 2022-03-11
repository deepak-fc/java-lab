package numoperation;

public class PrimeNumber {

    // uses number of factors to decide prime or not.
    public static boolean isPrime(int number) {
        int numberOfFactors = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                numberOfFactors++;
        }
        return numberOfFactors == 2 ? true : false;
    }
}