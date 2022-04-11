import java.util.*;

public class App {
    int balance = 10000;
    int Userpin = 2000705792;

    private int deposit(int amount) {
        balance = balance + amount;
        return balance;

    }

    private int withDraw(int amount) {
        balance = balance - amount;
        return balance;
    }

    private boolean pinCheck(int pin) {
        if (pin == Userpin) {
            return true;
        } else {
            return false;
        }

    }

    private int returnBalance() {
        return balance;
    }

    public static void menu() {
        System.out.println("\tBNK BANK MENU");
        System.out.println("\n1.Deposit\n2.Withdraw\n3.Balance\n4.Exit\n");

    }

    public static void main(String[] args) throws Exception {

        App app = new App();
        Scanner inputs = new Scanner(System.in);

        App.menu();

        System.out.println("Enter your choice:");
        int choice = inputs.nextInt();

        int sum = 0;

        while (choice != 4) {
            switch (choice) {
                case 1:
                System.out.println("\nPlease enter your pin to envok this action?");
                int pin = inputs.nextInt();
                boolean check = app.pinCheck(pin);
                System.out.println();
                if (check == true) {
                    System.out.println("\nEnter the amount to deposit:");
                    int amount = inputs.nextInt();
                    app.deposit(amount);
                    System.out.println();
                    System.out.printf(
                        "Thank you for banking with BNK. You have deposited %d and your new balance is %d\n",
                        amount, app.returnBalance());
                        System.out.println("\nEnter your choice:");
                        choice = inputs.nextInt();
                        
                    } else {
                        System.out.println("Wrong pin entered, please try again!!!");
                        sum++;
                        if(sum == 3){
                            System.out.println("\nYou have entered the wrong pin 3 times Now. Please try again later or contact the bank for assistance");
                            System.exit(0);
                        }
                    }

                    break;
                case 2:
                    System.out.println("\nPlease enter your pin to envok this action?");
                    int pin1 = inputs.nextInt();
                    boolean check1 = app.pinCheck(pin1);
                    if (check1 == true) {
                        System.out.println("\nEnter the amount to Withdraw:");
                        int amount1 = inputs.nextInt();
                        if (amount1 < app.returnBalance()) {
                            app.withDraw(amount1);
                            System.out.println();
                            System.out.printf(
                                    "Thank you for banking with BNK. You have Withdrawn %d and your new balance is %d\n",
                                    amount1, app.returnBalance());
                            System.out.println("\nEnter your choice:");
                            choice = inputs.nextInt();
                        }else{
                            System.out.println("\nYou have insufficient balance to withdraw");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Wrong pin entered, please try again!!!");
                        sum++;
                        if(sum == 3){
                            System.out.println("\nYou have entered the wrong pin 3 times Now. Please try again later or contact the bank for assistance");
                            System.exit(0);
                        }
                    }

                    break;
                case 3:
                    System.out.println("\nPlease enter your pin to envok this action?");
                    int pin2 = inputs.nextInt();
                    boolean check2 = app.pinCheck(pin2);
                    if (check2 == true) {
                        System.out.printf(
                                "\nThank you for banking with BNK. Your balance is %d\n",
                                app.returnBalance());
                        System.out.println("\nEnter your choice:");
                        choice = inputs.nextInt();

                    } else {
                        System.out.println("Wrong pin entered, please try again!!!");
                        sum++;
                        if(sum == 3){
                            System.out.println("\nYou have entered the wrong pin 3 times Now. Please try again later or contact the bank for assistance");
                            System.exit(0);
                        }
                    }

                    break;

                default:
                    System.out.println("Wrong choice, please choose again!");
                    System.out.println("\nEnter your choice:");
                    choice = inputs.nextInt();
                    break;
            }
            if (choice > 4) {
                break;
            }
        }

        inputs.close();
    }

}
