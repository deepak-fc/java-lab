package numoperation;

class ArmStrongNumber {
    public static boolean isArmstrong(int number) {

        int n = Integer.toString(number).length();
        int copyOfNumber = number;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(copyOfNumber % 10, n);
            copyOfNumber /= 10;
        }
        return (sum == number) ? true : false;
    }
}
