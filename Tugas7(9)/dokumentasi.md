
# Gambaran Umum

World of Zuul merupakan sebuah permainan petualangan berbasis teks (text-based adventure game) yang sederhana. Dalam permainan ini, pemain menjelajahi dunia yang terdiri dari beberapa ruangan yang saling terhubung. Pemain dapat berpindah dari satu ruangan ke ruangan lain serta memberikan berbagai perintah melalui input teks.

Proyek ini dibangun menggunakan enam class utama:

- Game → mengatur jalannya permainan dan logika interaksi antar elemen.

- Parser → memproses dan membaca perintah yang dimasukkan oleh pemain.

- Command → merepresentasikan satu perintah yang diberikan oleh pemain.

- CommandWords → menyimpan daftar perintah yang diizinkan dalam permainan.

- Room → menggambarkan lokasi atau ruangan dalam dunia permainan.

- Main → menjalankan program dengan membuat objek Game dan memanggil metode-metodenya.

# Desain Program

![](/img/7_alur.png)


# Demo Program 

![](/img/7_demo.png)

## Fitur Utama

- Menggunakan input teks sebagai cara berinteraksi: pemain mengetikkan perintah untuk bermain.

- Dapat berpindah antar ruangan (Room Navigation) dengan perintah seperti: go north, go south, go east, atau go west.

- Sistem memeriksa keabsahan perintah; jika perintah tidak dikenali, akan muncul pesan kesalahan.

- Menampilkan panduan penggunaan melalui perintah help.

- Permainan dapat diakhiri dengan perintah quit.

## Analisis Desain Kelas

Class Command

- Kohesi: Tinggi, karena seluruh atribut dan metode hanya berfokus pada pemrosesan input yang diberikan oleh pengguna.

- Kopling: Rendah, sebab kelas ini hanya berinteraksi dengan kelas Parser.

Class CommandWords

- Kohesi: Tinggi, karena seluruh metode dan atribut berfungsi untuk menyimpan serta memvalidasi daftar perintah yang sah.

- Kopling: Rendah, karena kelas ini hanya dimanfaatkan oleh Parser untuk memeriksa keabsahan perintah.

Class Room

- Kohesi: Tinggi, karena semua metode dan atribut berhubungan dengan pengaturan ruang serta arah keluar (exit).

- Kopling: Sedang, sebab setiap objek Room memiliki referensi langsung ke Room lain, sehingga tercipta ketergantungan antar objek.

Class Parser

- Kohesi: Tinggi, karena seluruh fungsinya berpusat pada pembacaan input pemain dan pembentukan objek Command.

- Kopling: Sedang, karena bergantung pada CommandWords untuk memvalidasi perintah dan Command untuk membuat objek hasil parsing.

Class Game

- Kohesi: Sedang, sebab kelas ini menangani berbagai tanggung jawab sekaligus, seperti inisialisasi ruang, pengaturan alur permainan, dan interaksi dengan pemain.

- Kopling: Tinggi, karena Game berinteraksi langsung dengan banyak kelas lain seperti Room, Parser, dan Command, serta bergantung pada detail internal masing-masing.

## Kesimpulan

Secara keseluruhan, desain program World of Zuul tergolong baik karena sebagian besar kelas memiliki tingkat cohesion yang tinggi. Kelas seperti Command, CommandWords, dan Parser menunjukkan penerapan prinsip tanggung jawab tunggal dengan baik, tanpa mencampurkan logika dari komponen lain. Namun, Class Game dan Class Room masih memiliki coupling yang relatif tinggi karena keduanya saling bergantung dan sering mengakses atribut kelas lain secara langsung. Kondisi ini dapat menimbulkan dampak ketika terjadi perubahan pada salah satu kelas, yang kemudian memengaruhi kelas lainnya.


