# Inheritance

## Tujuan :
Meningkatkan keterbacaan kode serta mempermudah pemeliharaan kode.

## Class :
Terdapat beberapa class, yaitu :

- Class Kendaraan, sebagai class induk yang membawahi dari class turunan Mobil, Motor, Sepeda.
- Class Mobil, sebagai class turunan dari class Kendaraan yang menyimpan informasi kendaraan mobil (merk, model, tahun produksi, jumlah roda).
- Class Motor, sebagai class turunan dari class Kendaraan yang menyimpan informasi kendaraan motor (merk, model, tahun produksi, jumlah roda).
- Class Sepeda, sebagai class turunan dari class Kendaraan yang menyimpan informasi kendaraan sepeda (merk, model, tahun produksi, jenis sepeda).
- Class Penyewa, sebagai class yang mencatat detail nama penyewa dan jenis kendaraan yang disewa.
- Class Main, sebagai class utama untuk membuat objek kendaraan sesuai jenisnya, menambahkan list penyewa, serta berfungsi untuk menampilkan list kendaraan yang tersedia, daftar nama penyewa serta informasi detail kendaraan yang disewa.

## Class Diagram :

![](/img/11_alur.png)


## Konsep OOP :

1. **Inheritance (Pewarisan)**
    - Kendaraan -> Mobil, Motor, Sepeda
        Semua kendaraan berbagi atribut dasar dan dapat dimodifikasi pada setiap kelasnya.
        
2. **Polymorphism**
    - Daftar kendaraan disimpan dalam `ArrayList<Kendaraan>`
        
        Namun objek di dalamnya bisa berupa Mobil, Motor, atau Sepeda.
        
        Pemanggilan `getInfo()` otomatis menyesuaikan jenis kelasnya.

3. **Association (Hubungan Objek)**
    - Penyewa memiliki minimal satu kendaraan.

## Demonstrasi :

![](/img/11_demo.png)



