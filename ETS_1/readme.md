# Dokumentasi Vending Coffee Machine

[Link Youtube](https://youtu.be/HbKLP7mDQNs)

## Deskripsi Project
Aplikasi simulasi mesin vending kopi sesuai alur :

- Pengguna memilih jenis dan ukuran kopi.
- Pengguna menambah gula/susu (opsional).
- Mesin menampilkan total harga.
- Pengguna melakukan pembayaran.
- Mesin memverifikasi pembayaran → jika cukup → membuat kopi.
- Kopi disajikan → sistem mengurangi stok.
- Transaksi disimpan ke log.
- Jika stok habis → admin diingatkan untuk refill.


## Struktur Kelas

### 1. **Stock Class**
contoh :
```
class Coffee {
    private String name;   // Nama kopi
    private int price;     // Harga dasar
    private int stock;     // Jumlah stok
}
```
Class yang ada :
- Coffee
- Sugar
- Milk

**Fungsi:**
- Menyimpan informasi dan mengelola stok
- Method: `getName()`, `getPrice()`, `getStock()`, `reduceStock()`, `isAvailable()`

---

### 2. **Class Transaction**
**Fungsi:**
- Merekam setiap transaksi yang terjadi
- Menyimpan waktu transaksi secara otomatis
- Method: `getOrder()`, `getPrice()`, `getDate()`

---

### 3. **Class VendingCoffeeMachine**  (Main Class)
```java
public class VendingCoffeeMachine {
    private ArrayList<Coffee> menu;              // Daftar kopi
    private ArrayList<Transaction> transactionLog; // Log transaksi
    private Scanner scanner;                     // Input user
    private Sugar sugar;                         // Objek gula
    private Milk milk;                           // Objek susu
}
```
**Fungsi:**
- Kelas utama yang mengatur seluruh sistem
- Mengelola menu, transaksi, dan interaksi user

**Method penting:**
- `initializeMenu()` - Inisialisasi menu kopi dan topping
- `start()` - Method utama untuk menjalankan program
- `showMenu()` - Menampilkan daftar menu kopi
- `showTransactionLog()` - Menampilkan riwayat transaksi

---

## Alur tambahan : Loop dan Pemesanan Berulang

Program menggunakan `do-while(true)` untuk memungkinkan pemesanan berulang:

```java
boolean firstOrder = true;

do {
    if (firstOrder) {
        showMenu();
        firstOrder = false;
    }
    
    // ... proses pemesanan ...
    
    System.out.print("\nApakah ingin memesan lagi? (1 untuk ya, 0 untuk tidak): ");
    int orderAgain = scanner.nextInt();
    
    if (orderAgain == 1) {
        showMenu();
    } else {
        break; 
    }
    
} while (true);

showTransactionLog(); 
```

**Alur:**
1. Pertama kali → Langsung tampilkan menu
2. Setelah transaksi selesai → Tanya mau pesan lagi?
3. Jika ya (input 1) → Tampilkan menu lagi
4. Jika tidak (input 0) → Keluar dan tampilkan log semua transaksi

---

## Library yang Digunakan

```java
import java.util.Scanner;              // Untuk input dari user
import java.util.ArrayList;            // Untuk menyimpan daftar dinamis
import java.time.LocalDateTime;        // Untuk mendapatkan waktu saat ini
import java.time.format.DateTimeFormatter; // Untuk format tanggal
```
---

# Demo awal
![](/img/ets_success.png)

# Ketika Stok Habis
![](/img/ets_empty.png)

# Pola di BlueJ
![](/img/ets_blue.png)
