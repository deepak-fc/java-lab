package numoperation;

public class PerfectNumber {

    public static boolean isPerfect(int number) {
        int sumOfDivisors = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                sumOfDivisors += i;
        }
        return ((sumOfDivisors > 0) && (sumOfDivisors == number)) ? true : false;
    }
}
