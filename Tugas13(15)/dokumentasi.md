# Java CRUD Database

Program Java console sederhana untuk operasi CRUD pada tabel buku.

## Setup

1. **Download MySQL Connector/J**  
   Link: https://dev.mysql.com/downloads/connector/j/  
   Pilih *Platform Independent* → download file `.zip`.

2. **Ambil file `.jar`**  
   Ekstrak zip → ambil file `mysql-connector-java-xx.jar`.

3. **Tambahkan ke BlueJ**  
   BlueJ → `Tools` → `Preferences` → `Libraries` → *Add* → pilih file `.jar`.  
   Restart BlueJ.

4. **Setup database (XAMPP)**  
   - Jalankan XAMPP → start **Apache** & **MySQL**  
   - Buka: `localhost/phpmyadmin/`  
   - Jalankan query dari `prep.sql` untuk membuat database `perpustakaan` dan tabel `buku`.

---

## Penjelasan Alur

Program ini merupakan aplikasi CRUD sederhana menggunakan Java dan MySQL.

**Alur utama:**
1. Program memuat driver JDBC.  
2. Membuat koneksi ke database `perpustakaan`.  
3. Membuat `Statement` untuk eksekusi SQL.  
4. Program menampilkan menu:  
   - `1` → insert data  
   - `2` → show data  
   - `3` → update data  
   - `4` → delete data  
   - `0` → keluar program  
5. Proses berulang sampai pengguna memilih keluar.  
6. Setelah selesai, koneksi dan statement ditutup.

**Operasi CRUD:**
- `insertBuku()` → memasukkan judul & pengarang ke tabel.  
- `showData()` → menampilkan daftar buku dari query `SELECT * FROM buku`.  
- `updateBuku()` → memperbarui data berdasarkan `id_buku`.  
- `deleteBuku()` → menghapus data berdasarkan `id_buku`.

---

## Hasil :

### Phpmyadmin Database
![](/img/15_db.png)

### Input
![](/img/15_input.png)

### Update
![](/img/15_update.png)

### Delete
![](/img/15_delete.png)
