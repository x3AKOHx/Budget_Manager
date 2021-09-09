package budget;

import java.util.Scanner;

public class Menu {
    public static void mainMenu() {
        Balance balance = new Balance();
        Purchase purchase = new Purchase();
        while (true) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Analyze (Sort)");
            System.out.println("0) Exit");

            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            System.out.println();

            switch (pick) {
                case 1: {
                    System.out.println("Enter income:");
                    double amount = sc.nextDouble();
                    balance.addIncome(amount);
                    break;
                }
                case 2: {
                    purchase.addPurchase(balance);
                    break;
                }
                case 3: {
                    purchase.showPurchases();
                    break;
                }
                case 4: {
                    System.out.println("Balance: $" + balance.getBalance());
                    break;
                }
                case 5: {
                    FileSave.saveToFile(purchase, balance);
                    break;
                }
                case 6: {
                    FileSave.loadFromFile(purchase, balance);
                    break;
                }
                case 7: {
                    Analyzer.analyzeMenu(purchase);
                    break;
                }
                case 0: {
                    System.out.println("Bye!");
                    System.exit(0);
                }
                default: {
                    System.out.println("Wrong input");
                    break;
                }
            }
            System.out.println();
        }
    }
}
