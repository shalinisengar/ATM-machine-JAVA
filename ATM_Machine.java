import java.util.Scanner;

class ATM {
    int pin;
    float balance;

    public void call() {
        System.out.println("1. Create PIN (if use first time)");
        System.out.println("2. Use PIN");
        try (Scanner cc = new Scanner(System.in)) {
            int opt = cc.nextInt();
            if (opt == 1) {
                createpin();
            } else if (opt == 2) {
                checkPin();
            } else {
                System.out.println("Enter valid number");
                menu();
            }

        }
    }

    public void createpin() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Create your PIN:");
            pin = sc.nextInt();
            checkPin();

        }
    }

    public void checkPin() {

        System.out.println("Enter your valid PIN :");
        try (Scanner vpin = new Scanner(System.in)) {
            int Vpin = vpin.nextInt();
            if (Vpin == pin) {
                menu();
            } else {
                System.out.println("Invalid PIN");
                checkPin();
            }
        }

    }

    public void menu() {
        System.out.println("1. check A/C balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Diposite Money");
        System.out.println("4. Exit...!");
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            if (n == 1) {
                checkbalance();
            } else if (n == 2) {
                withdrawmoney();
            } else if (n == 3) {
                dipositeMoney();
            } else {
                System.out.println("Thnak you..!!!");
                return;

            }
        }
    }

    public void checkbalance() {
        System.out.println("balance :" + balance);
        menu();
    }

    public void withdrawmoney() {
        System.out.println("Enter the withdraw amount : ");
        try (Scanner sc = new Scanner(System.in)) {
            int money = sc.nextInt();
            if (money > balance) {
                System.out.println("insufficiant money");
            } else {
                balance = balance - money;
                System.out.println("Succesfuly withdraw money.");

            }
            menu();
        }

    }

    public void dipositeMoney() {
        System.out.println("Enter diposite amount : ");
        try (Scanner sc = new Scanner(System.in)) {
            int diposite = sc.nextInt();
            balance = balance + diposite;
            System.out.println("Succesfully Diposite Money");
            menu();
        }

    }

}

public class ATM_Machine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.call();
    }
}
