package budget;

import java.util.*;

public class Analyzer {

    public static void analyzeMenu(Purchase purchase) {
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("How do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");

            Scanner sc = new Scanner(System.in);
            int pick = sc.nextInt();
            System.out.println();

            switch (pick) {
                case 1: {
                    sortAll(purchase);
                    break;
                }
                case 2: {
                    sortByType(purchase);
                    break;
                }
                case 3: {
                    sortCertain(purchase);
                    break;
                }
                case 4: {
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

    public static void sortAll(Purchase purchase) {
        sort(purchase.getAllLists());
    }

    public static void sortByType(Purchase purchase) {
        HashMap<String, ArrayList<String>> map = purchase.purchases;
        TreeMap<Double, String> TreeMap = new TreeMap<>();
        double temp = 0;
        if (map.get("Food") != null) {
            for (String x : map.get("Food")) {
                temp += Double.parseDouble(x.substring(x.lastIndexOf("$") + 1));
            }
        }
        TreeMap.put(temp, "Food - $" + String.format("%.2f", temp));
        temp = 0;
        if (map.get("Entertainment") != null) {
            for (String x : map.get("Entertainment")) {
                temp += Double.parseDouble(x.substring(x.lastIndexOf("$") + 1));
            }
        }
        TreeMap.put(temp, "Entertainment - $" + String.format("%.2f", temp));
        temp = 0;
        if (map.get("Clothes") != null) {
            for (String x : map.get("Clothes")) {
                temp += Double.parseDouble(x.substring(x.lastIndexOf("$") + 1));
            }
        }
        TreeMap.put(temp, "Clothes - $" + String.format("%.2f", temp));
        temp = 0;
        if (map.get("Other") != null) {
            for (String x : map.get("Other")) {
                temp += Double.parseDouble(x.substring(x.lastIndexOf("$") + 1));
            }
        }
        TreeMap.put(temp, "Other - $" + String.format("%.2f", temp));
        temp = 0;
        for (String x : TreeMap.descendingMap().values()) {
            System.out.println(x);
        }
        for (Double x : TreeMap.keySet()) {
            temp += x;
        }
        System.out.println("Total: $" + String.format("%.2f", temp));
        System.out.println();
    }

    public static void sortCertain(Purchase purchase) {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");

        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();
        System.out.println();

        switch (pick) {
            case 1: {
                sort(purchase.purchases.get("Food"));
                break;
            }
            case 2: {
                sort(purchase.purchases.get("Clothes"));
                break;
            }
            case 3: {
                sort(purchase.purchases.get("Entertainment"));
                break;
            }
            case 4: {
                sort(purchase.purchases.get("Other"));
                break;
            }
            default: {
                System.out.println("Wrong input");
                break;
            }
        }
    }

    private static void sort(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {
            double total = 0;
            int n = list.size();
            String temp;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    double x = Double.parseDouble(list.get(j - 1).substring(list.get(j - 1).lastIndexOf("$") + 1));
                    double y = Double.parseDouble(list.get(j).substring(list.get(j).lastIndexOf("$") + 1));
                    if (x > y) {
                        temp = list.get(j - 1);
                        list.set(j - 1, list.get(j));
                        list.set(j, temp);
                    }
                }
                total += Double.parseDouble(list.get(i).substring(list.get(i).lastIndexOf("$") + 1));
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
            System.out.println("Total: $" + String.format("%.2f", total));
        }
        System.out.println();
    }
}
