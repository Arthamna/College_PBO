import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    private String nim;
    private String nama;
    private ArrayList<MataKuliah> matkulDiambil;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.matkulDiambil = new ArrayList<>();
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void tambahMatkul(MataKuliah matkul) {
        matkulDiambil.add(matkul);
    }

    public boolean hapusMatkul(String kodeMatkul) {
        for (int i = 0; i < matkulDiambil.size(); i++) {
            if (matkulDiambil.get(i).getKodeMatkul().equals(kodeMatkul)) {
                matkulDiambil.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<MataKuliah> getMatkulDiambil() {
        return matkulDiambil;
    }

    public int getTotalSKS() {
        int total = 0;
        for (MataKuliah mk : matkulDiambil) {
            total += mk.getSks();
        }
        return total;
    }
}

class MataKuliah {
    private String kodeMatkul;
    private String namaMatkul;
    private Dosen dosenPengajar;
    private int sks;

    public MataKuliah(String kodeMatkul, String namaMatkul, Dosen dosenPengajar, int sks) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.dosenPengajar = dosenPengajar;
        this.sks = sks;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public Dosen getDosenPengajar() {
        return dosenPengajar;
    }

    public int getSks() {
        return sks;
    }

    @Override
    public String toString() {
        return kodeMatkul + " - " + namaMatkul + " (" + sks + " SKS) - Dosen: " + dosenPengajar.getNamaDosen();
    }
}

class Dosen {
    private String namaDosen;
    private String kodeDosen;

    public Dosen(String namaDosen, String kodeDosen) {
        this.namaDosen = namaDosen;
        this.kodeDosen = kodeDosen;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    @Override
    public String toString() {
        return kodeDosen + " - " + namaDosen;
    }
}

public class Main {
    private static ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private static ArrayList<MataKuliah> daftarMatkul = new ArrayList<>();
    private static Mahasiswa mahasiswa;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initDataDosen();
        initDataMatkul();

        int choice = -1;

        while (choice != 6) {
            System.out.println("\n=== Menu Pengambilan Mata Kuliah ===");
            System.out.println("1. Input data mahasiswa");
            System.out.println("2. Tambah Mata Kuliah");
            System.out.println("3. Hapus Mata Kuliah");
            System.out.println("4. Daftar Mata Kuliah yang Diambil");
            System.out.println("5. Lihat Semua Mata Kuliah Tersedia");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Masukan harus angka!");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputDataMahasiswa();
                    break;
                case 2:
                    tambahMataKuliah();
                    break;
                case 3:
                    hapusMataKuliah();
                    break;
                case 4:
                    tampilkanMatkulDiambil();
                    break;
                case 5:
                    tampilkanSemuaMatkul();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        scanner.close();
    }
    // dummy init :: 
    private static void initDataDosen() {
        daftarDosen.add(new Dosen("Dr. Ahmad Suharto", "DSN001"));
        daftarDosen.add(new Dosen("Dr. Siti Nurhaliza", "DSN002"));
        daftarDosen.add(new Dosen("Prof. Budi Santoso", "DSN003"));
        daftarDosen.add(new Dosen("Dr. Maya Sari", "DSN004"));
    }

    private static void initDataMatkul() {
        daftarMatkul.add(new MataKuliah("IF101", "Pemrograman Dasar", daftarDosen.get(0), 3));
        daftarMatkul.add(new MataKuliah("IF102", "Struktur Data", daftarDosen.get(1), 3));
        daftarMatkul.add(new MataKuliah("IF103", "Basis Data", daftarDosen.get(2), 3));
        daftarMatkul.add(new MataKuliah("IF104", "Algoritma", daftarDosen.get(3), 2));
        daftarMatkul.add(new MataKuliah("IF105", "Jaringan Komputer", daftarDosen.get(0), 3));
    }
    // func
    private static void inputDataMahasiswa() {
        System.out.println("=== Input Data Mahasiswa ===");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        mahasiswa = new Mahasiswa(nim, nama);
        System.out.println("Data mahasiswa berhasil disimpan!");
    }

    private static void tambahMataKuliah() {
        if (mahasiswa == null) {
            System.out.println("Silakan input data mahasiswa terlebih dahulu (menu 1).");
            return;
        }

        System.out.println("\n=== Tambah Mata Kuliah ===");
        tampilkanSemuaMatkul();

        System.out.print("Masukkan kode mata kuliah yang ingin diambil: ");
        String kodeMatkul = scanner.nextLine();

        MataKuliah matkulDipilih = null;
        for (MataKuliah mk : daftarMatkul) {
            if (mk.getKodeMatkul().equals(kodeMatkul)) {
                matkulDipilih = mk;
                break;
            }
        }

        if (matkulDipilih == null) {
            System.out.println("Mata kuliah tidak ditemukan!");
            return;
        }

        for (MataKuliah mk : mahasiswa.getMatkulDiambil()) {
            if (mk.getKodeMatkul().equals(kodeMatkul)) {
                System.out.println("Mata kuliah sudah diambil!");
                return;
            }
        }

        mahasiswa.tambahMatkul(matkulDipilih);
        System.out.println("Mata kuliah berhasil ditambahkan!");
    }

    private static void hapusMataKuliah() {
        if (mahasiswa == null) {
            System.out.println("Silakan input data mahasiswa terlebih dahulu (menu 1).");
            return;
        }

        System.out.println("\n=== Hapus Mata Kuliah ===");

        if (mahasiswa.getMatkulDiambil().isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil!");
            return;
        }

        tampilkanMatkulDiambil();
        System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
        String kodeMatkul = scanner.nextLine();

        if (mahasiswa.hapusMatkul(kodeMatkul)) {
            System.out.println("Mata kuliah berhasil dihapus!");
        } else {
            System.out.println("Mata kuliah tidak ditemukan!");
        }
    }

    private static void tampilkanMatkulDiambil() {
        if (mahasiswa == null) {
            System.out.println("Silakan input data mahasiswa terlebih dahulu (menu 1).");
            return;
        }

        System.out.println("\n=== Daftar Mata Kuliah yang Diambil ===");
        System.out.println("Mahasiswa: " + mahasiswa.getNama() + " (" + mahasiswa.getNim() + ")");

        if (mahasiswa.getMatkulDiambil().isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            System.out.println("Mata kuliah yang diambil:");
            for (int i = 0; i < mahasiswa.getMatkulDiambil().size(); i++) {
                System.out.println((i + 1) + ". " + mahasiswa.getMatkulDiambil().get(i));
            }
            System.out.println("Total SKS: " + mahasiswa.getTotalSKS());
        }
    }

    private static void tampilkanSemuaMatkul() {
        System.out.println("\n=== Daftar Semua Mata Kuliah ===");
        for (int i = 0; i < daftarMatkul.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMatkul.get(i));
        }
    }
}
