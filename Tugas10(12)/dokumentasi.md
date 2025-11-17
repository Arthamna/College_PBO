# Tugas 1 : Abstraksi Makhluk Hidup
## Penjelasan Singkat

- Class MakhlukHidup

Merupakan superclass abstrak bagi semua makhluk hidup. Menyimpan atribut nama serta tiga method abstrak: bernapas(), tidur(), dan makan(), yang wajib dioverride oleh setiap subclass. Class ini menjadi dasar pewarisan perilaku umum bagi manusia, hewan, dan tumbuhan.

- Class Manusia

Subclass dari MakhlukHidup. Meng-override method bernapas(), makan(), dan tidur() untuk menampilkan perilaku manusia. Memiliki method tambahan bangun() yang hanya dimiliki oleh manusia. Saat dipanggil, setiap method menampilkan aksi yang dilakukan oleh manusia sesuai namanya.

- Class Hewan

Subclass dari MakhlukHidup. Meng-override method bernapas(), makan(), dan tidur() untuk menggambarkan perilaku hewan. Memiliki method tambahan bertarung() yang menunjukkan kemampuan hewan untuk bertarung. Setiap aksi dicetak melalui output console.

- Class Tumbuhan

Subclass dari MakhlukHidup. Meng-override method bernapas(), makan(), dan tidur() dengan perilaku khas tumbuhan, seperti menyerap karbon dioksida dan tidak tidur seperti hewan. Memiliki method tambahan fotosintesis() yang menjelaskan proses tumbuhan membuat makanan.

- Class Main

Merupakan class utama untuk menjalankan program. Di dalam main(), dibuat objek dari Manusia, Hewan, dan Tumbuhan, kemudian dipanggil method-method masing-masing untuk menunjukkan perbedaan perilaku (konsep inheritance dan polymorphism). Program menampilkan serangkaian output sesuai perilaku tiap makhluk hidup yang dipanggil.

## Dokumentasi 

### Struktur
![](/img/12_struktur1.png)
### Demonstrasi
![](/img/12_demo.png)

# Tugas 2 : Simulasi Rabbit and Fox
## Penjelasan Singkat

- Class Animal

Abstract class yang menjadi superclass untuk semua hewan dalam simulasi. Menyimpan atribut dasar seperti umur, status hidup/mati, lokasi hewan pada grid, serta referensi ke Field tempat hewan berada. Menyediakan mekanisme umum seperti pindah lokasi, mati, dan pengecekan status hidup. Memiliki method abstract act() yang wajib di-override oleh setiap subclass untuk mendefinisikan perilaku hewan pada setiap langkah simulasi.

- Class Rabbit

Subclass dari Animal yang merepresentasikan kelinci dalam simulasi. Perilaku utamanya adalah bergerak ke salah satu lokasi kosong di sekitar posisinya. Pada method act(), Rabbit akan mencari sel kosong di adjacent cell. Jika ada, Rabbit pindah ke lokasi tersebut. Jika tidak ada tempat untuk bergerak, Rabbit akan mati karena terjebak. Rabbit tidak menyerang dan tidak mencari makanan.

- Class Fox

Subclass dari Animal yang merepresentasikan rubah dalam simulasi. Perilaku utama Fox adalah berburu Rabbit. Saat act() dipanggil, Fox akan mencari Rabbit di sel-sel sekitar posisinya menggunakan method findFood(). Jika menemukan Rabbit, Fox memakan Rabbit (Rabbit di-set dead), lalu Fox berpindah ke lokasi tersebut. Jika tidak menemukan makanan, Fox berusaha bergerak ke salah satu lokasi kosong terdekat. Bila tidak ada ruang untuk bergerak dan tidak menemukan makanan, Fox akan mati karena tidak dapat bertahan hidup.

- Class Field

Merepresentasikan peta/grid 2D tempat simulasi berlangsung. Setiap cell dapat berisi Fox, Rabbit, atau kosong. Field menyediakan berbagai method penting seperti menempatkan objek di lokasi tertentu, menghapus objek, mendapatkan objek pada lokasi, mencari lokasi kosong di sekitar suatu posisi, serta menghasilkan daftar lokasi adjacent. Field adalah pusat data yang melacak posisi semua hewan selama simulasi.

- Class Location

Class sederhana yang menyimpan koordinat baris (row) dan kolom (col) dalam grid. Lokasi ini digunakan oleh Animal, Field, dan Simulator untuk menentukan posisi setiap objek. Object immutabel sederhana yang hanya berfungsi sebagai penanda posisi.

- Class SimulatorView

Komponen GUI berbasis Swing yang bertugas menggambar tampilan simulasi dalam bentuk grid visual. Setiap cell grid digambar sebagai kotak kecil berwarna:
-> ORANGE untuk Rabbit
-> BLUE untuk Fox

Metode showStatus() menerima object Field dan memanggil repaint() untuk memperbarui tampilan sesuai kondisi terbaru.

- Class Simulator

Mengatur seluruh jalannya simulasi—baik logika maupun antarmuka GUI. Simulator membuat field, menempatkan hewan-hewan awal secara acak berdasarkan probabilitas, dan menjalankan simulasi menggunakan Timer agar bergerak otomatis tiap 100 ms. Pada setiap langkah (simulateOneStep()), semua hewan menjalankan perilaku mereka melalui method act(). Simulator juga memperbarui GUI melalui SimulatorView, menampilkan jumlah populasi, serta menjalankan permainan secara berkelanjutan. Class ini adalah pusat kontrol dari seluruh sistem.

## Dokumentasi 

### Struktur
![](/img/12_struktur2.png)
### Demonstrasi
![](/img/12_rabbitfox.png)
