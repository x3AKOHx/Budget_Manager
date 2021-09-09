package budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Purchase {

    private final ArrayList<String> food = new ArrayList<>();
    private final ArrayList<String> clothes = new ArrayList<>();
    private final ArrayList<String> entertainment = new ArrayList<>();
    private final ArrayList<String> other = new ArrayList<>();
    HashMap<String, ArrayList<String>> purchases = new HashMap<>();

    public void addPurchase(Balance balance) {
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Choose the type of purchase");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) Back");

            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            System.out.println();

            switch (pick) {
                case 1: {
                    addPurchaseInGroup(balance, food);
                    purchases.put("Food", food);
                    break;
                }
                case 2: {
                    addPurchaseInGroup(balance, clothes);
                    purchases.put("Clothes", clothes);
                    break;
                }
                case 3: {
                    addPurchaseInGroup(balance, entertainment);
                    purchases.put("Entertainment", entertainment);
                    break;
                }
                case 4: {
                    addPurchaseInGroup(balance, other);
                    purchases.put("Other", other);
                    break;
                }
                case 5: {
                    isTrue = false;
                    break;
                }
                default: {
                    System.out.println("Wrong input");
                    break;
                }
            }
        }
    }

    public void showPurchases() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Choose the type of purchase");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) All");
            System.out.println("6) Back");

            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            System.out.println();

            switch (pick) {
                case 1: {
                    purchaseInfo(food);
                    break;
                }
                case 2: {
                    purchaseInfo(clothes);
                    break;
                }
                case 3: {
                    purchaseInfo(entertainment);
                    break;
                }
                case 4: {
                    purchaseInfo(other);
                    break;
                }
                case 5: {
                    purchaseInfo();
                    break;
                }
                case 6: {
                    isTrue = false;
                    break;
                }
                default: {
                    System.out.println("Wrong input");
                    break;
                }
            }
        }
    }

    public void setPurchases(HashMap<String, ArrayList<String>> purchases) {
        this.purchases = purchases;
        if (purchases.get("Food") != null) {
            food.addAll(purchases.get("Food"));
        }
        if (purchases.get("Clothes") != null) {
            clothes.addAll(purchases.get("Clothes"));
        }
        if (purchases.get("Entertainment") != null) {
            entertainment.addAll(purchases.get("Entertainment"));
        }
        if (purchases.get("Other") != null) {
            other.addAll(purchases.get("Other"));
        }
    }

    private void addPurchaseInGroup(Balance balance, ArrayList<String> list) {
        System.out.println("Enter purchase name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter its price:");
        double price = sc.nextDouble();
        if (balance.addPurchase(price)) {
            list.add(name + " " + "$" + String.format ("%.2f", price));
            System.out.println("Purchase was added!");
            System.out.println();
        }
    }

    private void purchaseInfo(ArrayList<String> list) {
        double totalAmount = 0;
        if (list.isEmpty()) {
            System.out.println("The purchase list is empty");
        } else {
            for (String x : list) {
                totalAmount += Double.parseDouble(x.substring(x.lastIndexOf("$") + 1));
                System.out.println(x);
            }
            System.out.println("Total sum: $" + totalAmount);
        }
        System.out.println();
    }

    private void purchaseInfo() {
        double totalAmount = 0;
        ArrayList<String> list = new ArrayList<>();
        list.addAll(food);
        list.addAll(clothes);
        list.addAll(entertainment);
        list.addAll(other);

        if (list.isEmpty()) {
            System.out.println("The purchase list is empty");
        } else {
            for (String x : list) {
                totalAmount += Double.parseDouble(x.substring(x.lastIndexOf("$") + 1));
                System.out.println(x);
            }
            System.out.println("Total sum: $" + totalAmount);
        }
        System.out.println();
    }

    public ArrayList<String> getAllLists() {
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(food);
        temp.addAll(clothes);
        temp.addAll(entertainment);
        temp.addAll(other);
        return temp;
    }
}
