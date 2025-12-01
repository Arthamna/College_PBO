# Pong Game

Permainan Pong ini dapat dimainkan oleh satu atau dua pemain. Untuk mode single-player, pemain akan melawan bot  Untuk mode dua pemain, game berjalan secara lokal di satu komputer sehingga kedua pemain mengontrol paddle masing-masing pada keyboard yang sama.
Kontrol: Player 1 bergerak menggunakan tombol W (naik) dan S (turun); Player 2 menggunakan Arrow Up (naik) dan Arrow Down (turun).

### Class Diagram
![](/img/14_topo.png)

## Penjelasan Kelas

Terdapat 4 kelas yang digunakan dalam implementasi game pong ini, yaitu:

- Ball: Mengatur perilaku bola dalam permainan—posisi, arah dan kecepatan gerak; pantulan pada dinding atas/bawah; deteksi tabrakan (collision) dengan paddle; peningkatan kecepatan setelah beberapa kali terpental dari paddle; dan logika pemberian skor. Ketika sebuah skor tercipta, bola direset ke tengah lewat metode spawn().

- Paddle: Merepresentasikan paddle pemain (kiri dan kanan). Menyimpan posisi paddle, mengelola perpindahan ke atas dan ke bawah sesuai input pemain (Player 1: W/S, Player 2: Arrow Up/Arrow Down), mencegah paddle keluar dari area permainan, menyimpan skor pemain, serta bertanggung jawab atas penggambaran visual paddle di layar.

- Renderer: Berperan sebagai kanvas untuk menggambar seluruh objek game. Kelas ini merupakan turunan JPanel yang meng-override paintComponent() dan memanggil Pong.render() agar tampilan permainan diperbarui setiap frame.

- Pong: Kelas utama yang menjadi pengendali alur permainan. Tugasnya meliputi pembuatan jendela game, menjalankan game loop (mis. via timer), menangani input keyboard, mengatur status permainan (menu, pause, play, game over), mengelola mode bot, menghitung skor, serta mengoordinasikan update dan render seluruh objek game.

## Hasil :

## Menu
![](/img/14_menu.png)
### Game
![](/img/14_play.png)
### Menang
![](/img/14_win.png)

