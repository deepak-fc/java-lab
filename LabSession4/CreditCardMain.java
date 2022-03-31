import java.io.*;

interface CreditCardInterface {
    void viewCreditAmount();
    void useCard(float amountToSpend);
    void payCredit(float amountToPayBack);
    void increaseLimit(float amountToIncrease);
}

class SilverCardCustomer implements CreditCardInterface {
    String name;
    String cardNumber;
    float creditAmount;
    final float creditLimit;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    SilverCardCustomer() {
        this("", "");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    SilverCardCustomer(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.creditAmount = 0;
        this.creditLimit = 50000;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n-----------INPUT CARD DETAILS-----------");
        System.out.print("Enter Name: ");
        name = br.readLine();

        while (true) {
            System.out.print("Enter Card Number: ");
            cardNumber = br.readLine();
            if (isCardNumberValid(cardNumber))
                break;
            else
                System.out.println(">Invalid! Should be 16 digit numeric value.");
        }
        System.out.println("----------------------------------------\n");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static boolean isCardNumberValid(String cardNumber) {
        if (isStringNumeric(cardNumber) && cardNumber.length() == 16)
            return true;
        else
            return false;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static boolean isStringNumeric(String stringToCheck) {
        char[] stringIntoChars = stringToCheck.toCharArray();

        for (char c : stringIntoChars) {
            if (Character.isDigit(c) == false)
                return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void viewCreditAmount() {
        System.out.println("Current Credit Amount: " + creditAmount);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void useCard(float amountToSpend) {
        System.out.println(">Using Card...");

        if (amountToSpend <= 0) {
            System.out.println(">Transaction failed. Invalid amount.");
        } else if (amountToSpend > availableCreditBalance()) {
            System.out.println(">Transaction failed. You do not have sufficient credit balance.");
        } else {
            System.out.println(">Transaction successful for Rs." + amountToSpend);
            creditAmount += amountToSpend;
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    float availableCreditBalance() {
        return creditLimit - creditAmount;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void payCredit(float amountToPayBack) {
        if (amountToPayBack <= 0)
            System.out.println(">Transaction failed. Invalid pay back amount.");
        else if (amountToPayBack == creditAmount)
            payFullCredit(amountToPayBack);
        else if (amountToPayBack < creditAmount)
            payPartialCredit(amountToPayBack);
        else
            System.out.println(">Transaction failed. Enter amount less than or equal to " + creditAmount);
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void payFullCredit(float amountToPayBack) {
        creditAmount -= amountToPayBack;
        System.out.println(">Transaction successful. Paid back Rs." + amountToPayBack);
        System.out.println(">Current balance is: " + availableCreditBalance());
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void payPartialCredit(float amountToPayBack) {
        applyPenaltyCharges();
        creditAmount -= amountToPayBack;
        System.out.println(">Transaction successful. Paid back Rs." + amountToPayBack);
        System.out.println(">Current balance is: " + availableCreditBalance());
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    void applyPenaltyCharges() {
        float penaltyCharges = creditAmount * 0.05f;
        creditAmount += penaltyCharges;
        System.out.println(">Penalty charges Rs." + penaltyCharges + " added for next billing cycle.");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void increaseLimit(float amountToIncrease) {
        System.out.println(">Please upgrade to Gold Card for increasing credit limit.");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class GoldCardCustomer extends SilverCardCustomer {

    GoldCardCustomer() {

    }
    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////

}

class CreditCardMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int menuOption;

        SilverCardCustomer customer = new SilverCardCustomer();
        while (true) {

            displayChooseCardMenu();
            boolean isChooseCardMenuRunning = true;
            while (isChooseCardMenuRunning) {
                System.out.print("\nEnter menu option: ");
                menuOption = Integer.parseInt(br.readLine());

                switch (menuOption) {
                    case 1:
                        customer = new SilverCardCustomer();
                        customer.getUserInput();
                        isChooseCardMenuRunning = false;
                        break;
                    case 2:
                        customer = new GoldCardCustomer();
                        isChooseCardMenuRunning = false;
                        break;
                    case 3:
                        System.out.println(">Quitting program...");
                        System.exit(0);
                    default:
                        System.out.println(">Invalid menu option. Enter again.");
                }
            }

            boolean isCardActionsMenuRunning = true;
            while (isCardActionsMenuRunning) {
                displayCardActionsMenu();
                System.out.print("\nEnter menu option: ");
                menuOption = Integer.parseInt(br.readLine());

                switch (menuOption) {
                    case 1:
                        customer.viewCreditAmount();
                        break;
                    case 2:
                        System.out.print("Enter amount to spend: ");
                        float amountToSpend = Float.parseFloat(br.readLine());
                        customer.useCard(amountToSpend);
                        break;
                    case 3:
                        System.out.print("Enter amount to pay back: ");
                        float amountToPayBack = Float.parseFloat(br.readLine());
                        customer.payCredit(amountToPayBack);
                        break;
                    case 4:
                        System.out.print("Enter amount to increase limit: ");
                        float amountToIncrease = Float.parseFloat(br.readLine());
                        customer.increaseLimit(amountToIncrease);
                        break;
                    case 5:
                        isCardActionsMenuRunning = false;
                        break;
                    case 6:
                        System.out.println(">Quitting program...");
                        System.exit(0);
                    default:
                        System.out.println(">Invalid menu option. Enter again.");
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayChooseCardMenu() {
        System.out.println("\n-----------CHOOSE CARD MENU-------------");
        System.out.println("1. Silver Card");
        System.out.println("2. Gold Card");
        System.out.println("3. Quit program");
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayCardActionsMenu() {
        System.out.println("\n--------------CARD ACTIONS--------------");
        System.out.println("1. View Credit Amount");
        System.out.println("2. Use Card");
        System.out.println("3. Pay Credit");
        System.out.println("4. Increase Limit");
        System.out.println("5. Go back to previous menu");
        System.out.println("6. Quit program");
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}