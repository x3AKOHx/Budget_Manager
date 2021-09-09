package budget;

public class Balance {

    private double balance;

    public void addIncome(double income) {
        if (income > 0) {
            balance += income;
            System.out.println("Income was added!");
        } else {
            System.out.println("Wrong amount!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean addPurchase(double amount) {
        if (balance - amount < 0) {
            System.out.println("Not enough money!");
            System.out.println();
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
