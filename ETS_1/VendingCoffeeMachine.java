import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**  
  * Kelas ini berisi implementasi Vending Coffee Machine dengan alur kerja yang ditentukan dalam soal
  */  

class Coffee {
    private String name;
    private int price;
    private int stock;
    public Coffee(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    public void reduceStock() { 
        if (stock > 0) stock--; 
    }
    public boolean isAvailable() { 
        return stock > 0; 
    }
}

class Sugar {
    private String name;
    private int price;
    private int stock;
    public Sugar(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    public void reduceStock() { 
        if (stock > 0) stock--; 
    }
    public boolean isAvailable() { 
        return stock > 0; 
    }
}

class Milk {
    private String name;
    private int price;
    private int stock;
    public Milk(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    public void reduceStock() { 
        if (stock > 0) stock--; 
    }
    public boolean isAvailable() { 
        return stock > 0; 
    }
}

class Transaction {
    private String coffeeOrder;
    private int totalPrice;
    private String date;
    public Transaction(String coffeeOrder, int totalPrice) {
        this.coffeeOrder = coffeeOrder;
        this.totalPrice = totalPrice;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
    public String getCoffeeOrder() { return coffeeOrder; }
    public int getTotalPrice() { return totalPrice; }
    public String getDate() { return date; }
}

public class VendingCoffeeMachine{
    private ArrayList<Coffee> menu;
    private ArrayList<Transaction> transactionLog;
    private Scanner scanner;
    private Sugar sugar;
    private Milk milk;
    private void initializeMenu() {
        menu = new ArrayList<>();
        menu.add(new Coffee("Latte", 25000, 10));
        menu.add(new Coffee("Macchiato", 75000, 10));
        menu.add(new Coffee("Americano", 40000, 1));
        menu.add(new Coffee("Cappuccino", 65000, 10));
        menu.add(new Coffee("Espresso", 45000, 10));
        menu.add(new Coffee("Mocha", 35000, 10));
        sugar = new Sugar("Gula", 2000, 2);
        milk = new Milk("Susu", 5000, 2);
    }
    
    public void start(){
        scanner = new Scanner(System.in);
        initializeMenu();
        transactionLog = new ArrayList<>();
        boolean firstOrder = true;
        do {
            if (firstOrder) {
                showMenu();
                firstOrder = false;
            }
            
            System.out.print("Pilih kopi (1-6): ");
            int coffeeChoice = scanner.nextInt() - 1;
            Coffee selectedCoffee = menu.get(coffeeChoice);
            
            if (!selectedCoffee.isAvailable()) {
                System.out.println("Maaf, " + selectedCoffee.getName() + " habis!");
                continue;
            }
            
            int totalPrice = selectedCoffee.getPrice();
            
            System.out.println("Pilih ukuran:");
            System.out.println("1. Small (+Rp 0)");
            System.out.println("2. Medium (+Rp 5.000)");
            System.out.println("3. Large (+Rp 10.000)");
            System.out.print("Pilih ukuran: ");
            int sizeChoice = scanner.nextInt();
            String size = "Small";
            if (sizeChoice == 2) {
                totalPrice += 5000;
                size = "Medium";
            } else if (sizeChoice == 3) {
                totalPrice += 10000;
                size = "Large";
            }
            
            System.out.print("Tambah gula? (+Rp 2000) (1 untuk ya, 0 untuk tidak): ");
            int addSugar = scanner.nextInt();
            if (addSugar == 1) {
                if (sugar.isAvailable()) {
                    totalPrice += sugar.getPrice();
                } else {
                    System.out.println("Maaf, gula habis!");
                    addSugar = 0;
                }
            }
            
            System.out.print("Tambah susu? (+Rp 5000) (1 untuk ya, 0 untuk tidak): ");
            int addMilk = scanner.nextInt();
            if (addMilk == 1) {
                if (milk.isAvailable()) {
                    totalPrice += milk.getPrice();
                } else {
                    System.out.println("Maaf, susu habis!");
                    addMilk = 0;
                }
            }
            
            String orderDetails = selectedCoffee.getName() + " (" + size + ")";
            if (addSugar == 1) orderDetails += " + Gula";
            if (addMilk == 1) orderDetails += " + Susu";
            
            System.out.println("\n=== RINGKASAN PESANAN ===");
            System.out.println(orderDetails);
            System.out.println("Total: Rp " + String.format("%,d", totalPrice));
            System.out.println("========================");
            System.out.print("\nMasukkan uang: Rp ");
            int payment = scanner.nextInt();
            
            if (payment < totalPrice) {
                System.out.println("\nUang tidak cukup!");
                continue;
            }
            
            int change = payment - totalPrice;
            selectedCoffee.reduceStock();
            if (addSugar == 1) sugar.reduceStock();
            if (addMilk == 1) milk.reduceStock();
            
            transactionLog.add(new Transaction(orderDetails, totalPrice));
            
            System.out.println("Kopi Anda siap!");
            System.out.println("Kembalian: Rp " + String.format("%,d", change));
            
            if (!selectedCoffee.isAvailable()) {
                System.out.println("\nPERHATIAN: Stok " + selectedCoffee.getName() + " telah habis! Tolong diisi ulang oleh admin.");
            }
            if (!sugar.isAvailable()) {
                System.out.println("\nPERHATIAN: Stok gula telah habis! Tolong diisi ulang oleh admin.");
            }
            if (!milk.isAvailable()) {
                System.out.println("\nPERHATIAN: Stok susu telah habis! Tolong diisi ulang oleh admin.");
            }
            
            System.out.print("\nApakah ingin memesan lagi? (1 untuk ya, 0 untuk tidak): ");
            int orderAgain = scanner.nextInt();
            
            if (orderAgain == 1) {
                System.out.println();
                showMenu();
            } else {
                break;
            }
            
        } while (true);
        showTransactionLog();
    }
    
    private void showMenu() {
        System.out.println("Selamat datang di vending machine kopi :");
        System.out.println("\nMenu Kopi :");
        for (int i = 0; i < menu.size(); i++) {
            Coffee c = menu.get(i);
            String status = c.isAvailable() ? "[Stok: " + c.getStock() + "]" : "[HABIS]";
            System.out.printf("%d. %-12s Rp %,7d %s\n", 
                i + 1, c.getName(), c.getPrice(), status);
        }
    }
    
    private void showTransactionLog() {
        System.out.println("\n=== LOG TRANSAKSI ===");
        if (transactionLog.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            for (int i = 0; i < transactionLog.size(); i++) {
                Transaction t = transactionLog.get(i);
                System.out.printf("%d. [%s] %s - Rp %,d\n", 
                    i + 1, t.getDate(), t.getCoffeeOrder(), t.getTotalPrice());
            }
        }
    }
}
