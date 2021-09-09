package budget;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileSave {

    public static void saveToFile(Purchase purchase, Balance balance) {
        File file = new File("purchases.txt");
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(String.valueOf(balance.getBalance()));
            purchase.purchases.put("Balance", temp);
            os.writeObject(purchase.purchases);
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile(Purchase purchase, Balance balance) {
        File file = new File("purchases.txt");
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            HashMap<String, ArrayList<String>> temp = (HashMap<String, ArrayList<String>>) is.readObject();
            purchase.setPurchases(temp);
            balance.setBalance(Double.parseDouble(temp.get("Balance").get(0)));
            System.out.println("Purchases were loaded!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
