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
    float creditLimit;

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
        System.out.println(">Credit already used is Rs." + creditAmount);
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
    @Override
    public void payCredit(float amountToPayBack) {
        creditAmount -= amountToPayBack;
        System.out.println(">Transaction successful. Paid back Rs." + amountToPayBack);
        applyPenaltyChargesIfApplicable();
        System.out.println(">Available credit to use is Rs." + availableCreditBalance());
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
    void applyPenaltyChargesIfApplicable() {
        float penaltyCharges = creditAmount * 0.05f;
        creditAmount += penaltyCharges;
        System.out.println(">Penalty charges faced is Rs." + penaltyCharges);
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
    int hasIncreasedCreditLimit = 0;

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    GoldCardCustomer() {
        this("", "");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    GoldCardCustomer(String name, String cardNumber) {
        super(name, cardNumber);
        creditLimit = 100000;
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    @Override
    public void increaseLimit(float amountToIncrease) {
        if (hasIncreasedCreditLimit < 3) {
            if (amountToIncrease <= 0) {
                System.out.println(">Transaction failed. Cannot increase limit by 0 or less.");
            } else if (amountToIncrease > 5000) {
                System.out.println(">Transaction failed. Can only be increased by less or equal to Rs.5000");
            } else {
                creditLimit += amountToIncrease;
                hasIncreasedCreditLimit++;
                System.out.println(">Transaction successful. Increased the credit limit by Rs." + amountToIncrease);
            }
        } else {
            System.out.println(">Transaction failed. You have already increased the credit limit 3 times.");
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}

class CreditCardMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int menuOption;
        boolean isLoopActive;
        boolean isNestedLoopActive;

        SilverCardCustomer customer = new SilverCardCustomer();

        while (true) {
            displayChooseCardMenu();
            isLoopActive = true;
            while (isLoopActive) {
                System.out.print("\nEnter menu option: ");
                menuOption = Integer.parseInt(br.readLine());
                switch (menuOption) {
                    case 1:
                        customer = new SilverCardCustomer();
                        customer.getUserInput();
                        isLoopActive = false;
                        break;
                    case 2:
                        customer = new GoldCardCustomer();
                        customer.getUserInput();
                        isLoopActive = false;
                        break;
                    case 3:
                        System.out.println(">Quitting program...");
                        System.exit(0);
                    default:
                        System.out.println(">Invalid menu option. Enter again.");
                }
            }

            isLoopActive = true;
            while (isLoopActive) {
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
                        
                        if (customer.creditAmount == 0) {
                            System.out.println(">No dues to pay. Spend on something and come back later.");
                            break;
                        }
                
                        isNestedLoopActive = true;
                        while (isNestedLoopActive) {
                            displayCreditPaymentTypeMenu();
                            System.out.print("\nEnter menu option: ");
                            menuOption = Integer.parseInt(br.readLine());
                            switch (menuOption) {
                                case 1:
                                    customer.payCredit(customer.creditAmount);
                                    isNestedLoopActive = false;
                                    break;
                                case 2:
                                    float amountToPayBack;
                                    while (true) {
                                        System.out.print("Enter amount to pay back: ");
                                        amountToPayBack = Float.parseFloat(br.readLine());

                                        if (amountToPayBack <= 0)
                                            System.out.println(">Invalid amount. Should be greater than 0.");
                                        else if (amountToPayBack >= customer.creditAmount)
                                            System.out.println(
                                                    ">Invalid partial amount. Please select full payment to pay in full.");
                                        else
                                            break;
                                    }
                                    customer.payCredit(amountToPayBack);
                                    isNestedLoopActive = false;
                                    break;
                                case 3:
                                    isNestedLoopActive = false;
                                    break;
                                default:
                                    System.out.println(">Invalid menu option. Enter again.");
                            }
                        }
                        break;
                    case 4:
                        float amountToIncrease = 0;
                        if (customer instanceof GoldCardCustomer) {
                            if (((GoldCardCustomer) customer).hasIncreasedCreditLimit >= 3) {
                                System.out.println(">Already increased 3 times. Attempts exceeded.");
                                break;
                            } else {
                                System.out.print("Enter amount to increase limit: ");
                                amountToIncrease = Float.parseFloat(br.readLine());
                                customer.increaseLimit(amountToIncrease);
                                break;
                            }
                        }
                        customer.increaseLimit(amountToIncrease);
                        break;
                    case 5:
                        isLoopActive = false;
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
        System.out.println("1. View used credit amount");
        System.out.println("2. Use card");
        System.out.println("3. Pay credit");
        System.out.println("4. Increase limit");
        System.out.println("5. Go back to previous menu");
        System.out.println("6. Quit program");
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
    static void displayCreditPaymentTypeMenu() {
        System.out.println("\n-----------CHOOSE PAYMENT TYPE----------");
        System.out.println("1. Full payment");
        System.out.println("2. Partial payment (Interest will be charged)");
        System.out.println("3. Cancel");
        System.out.println("----------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////////////
}