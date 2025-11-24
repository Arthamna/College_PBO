# Latihan 1 : Login Form 
## Penjelasan Kode

- Class Login : Kelas utama yang memuat data kredensial (username & password), memiliki komponen input sebagai atribut, serta menyertakan inner class untuk menangani aksi pada tombol.

- txtUsername : Atribut berupa JTextField yang berfungsi sebagai field input teks untuk username.

- txtPassword : Atribut berupa JPasswordField yang menyediakan input untuk password.

- createAndShowGUI() : Method yang membangun keseluruhan antarmuka: membuat JFrame dan JPanel, menambahkan label, field, tombol, mengatur tata letak memakai GridBagLayout, memasang action listener pada tombol, menjalankan pack(), memusatkan jendela dengan setLocationRelativeTo(null), dan menampilkan frame lewat setVisible(true).

- LoginListener (inner class) : Inner class yang mengimplementasikan ActionListener untuk menangani aksi ketika tombol “Login” ditekan.

- CancelListener (inner class) : Inner class yang mengimplementasikan ActionListener untuk tombol “Cancel”, bertugas mereset input dan mengembalikan fokus ke field username.

- LoginListener.actionPerformed(ActionEvent e) : Method yang mengambil data input (txtUsername.getText() dan new String(txtPassword.getPassword())), mencocokkannya dengan USERNAME dan PASSWORD, menentukan pesan sukses/gagal, lalu menampilkan pesan melalui JOptionPane.showMessageDialog.

- CancelListener.actionPerformed(ActionEvent e) : Method yang mengosongkan nilai txtUsername dan txtPassword, serta mengembalikan fokus ke txtUsername dengan requestFocusInWindow().

- JOptionPane.showMessageDialog(...) : Fitur utility dari Swing untuk menampilkan dialog pesan sederhana kepada pengguna, dipakai untuk memberi informasi hasil proses login.

## Hasil :

### Struktur
![](/img/13_topo.png)
### Sukses Login
![](/img/13_success.png)
### Gagal Login
![](/img/13_gagal.png)


# Latihan 2 : Image Viewer
## Penjelasan Kode :

- Class ImageViewer: Berperan sebagai kelas utama (GUI) yang mengelola keseluruhan aplikasi: membuat jendela utama, menampilkan menu (Open, Close, Filter, Help), menangani interaksi pengguna, serta menjadi penghubung antara komponen seperti ImagePanel, OFImage, dan ImageFileManager.

- Class ImagePanel: Komponen yang bertugas menampilkan gambar. Kelas ini menggambar gambar ke layar, menyesuaikan skalanya agar tetap proporsional, dan menampilkan area kosong jika belum ada gambar yang dimuat.

- Class OFImage: Kelas untuk pemrosesan gambar yang mewarisi BufferedImage. Menyediakan operasi manipulasi pixel, seperti mengubah warna pixel, membuat gambar lebih gelap, lebih terang, atau memberikan efek threshold.

- Class ImageFileManager: Kelas utilitas untuk pengelolaan file gambar. Menangani proses membaca gambar dari file dan menyimpannya kembali menggunakan ImageIO.

### Struktur
![alt text](/img/13_2_topo.png)

### Normal 
![](/img/13_normal.png)

### Filter Utility
![](/img/13_filter.png)

### Open File Utility
![](/img/13_openfile.png)