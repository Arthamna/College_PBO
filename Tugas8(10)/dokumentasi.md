# Testing & Debugging

## Deskripsi Program

Program ini pengujian otomatis menggunakan JUnit digunakan untuk menguji sistem penjualan barang beserta komentar pelanggan yang ada.

![](/img/10_testing.png)


### Penjelasan hubungan antar object

- SalesItem menyimpan berbagai objek Comment melalui struktur ArrayList.
- Saat pengguna menambahkan komentar, SalesItem membuat objek Comment baru dan menambahkannya ke objek tersebut, juga memanggil fungsi di dalam seperti upvote dan downvote.
- Dalam pengujian, setiap test case membuat objek SalesItem baru dan memeriksa perilakunya menggunakan assertion dari JUnit seperti assertEquals, assertTrue, dan assertFalse.