import berkas.EksporKatalog;
import eksepsi.PustakaException;
import java.io.IOException;
import layanan.KatalogPerpustakaan;
import model.*;
import pembanding.UrutLayakLaluJudul;

public class Main {

    // [Atribusi AI]: Method main dibantu AI untuk menguji seluruh soal memakai
    // enam data wajib dari naskah.
    public static void main(String[] args) {
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "C-01");
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "C-02");
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15,
                "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8,
                "unduh.polmed.ac.id/bd002");

        System.out.println("=== Soal 2: Ringkasan Arsip ===");
        System.out.println(bk1.getKodeKoleksi() + " -> " + bk1.ringkasanArsip());
        System.out.println(bk2.getKodeKoleksi() + " -> " + bk2.ringkasanArsip());
        System.out.println(mj1.getKodeKoleksi() + " -> " + mj1.ringkasanArsip());
        System.out.println(mj2.getKodeKoleksi() + " -> " + mj2.ringkasanArsip());

        KatalogPerpustakaan katalog = new KatalogPerpustakaan();
        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(bd1);
        katalog.tambah(bd2);

        System.out.println("\n=== Soal 3: Status Seluruh Koleksi ===");
        katalog.cetakStatus();

        System.out.println("\n=== Soal 4: Urut Layak Lalu Judul ===");
        for (Koleksi k : katalog.urut(new UrutLayakLaluJudul())) {
            System.out.println(k.getKodeKoleksi() + " | " + k.getJudul()
                    + " | layak: " + k.layakDipinjam());
        }

        System.out.println("\n=== Soal 5: Peminjaman ===");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-002");
        cobaPinjam(katalog, "MJ-001");
        cobaPinjam(katalog, "XX-999");

        System.out.println("\n=== Soal 6: Ekspor ke katalog.txt ===");
        try {
            new EksporKatalog().tulisKatalog("katalog.txt", katalog.semuaKoleksi());
            System.out.println("katalog.txt sudah dibuat.");
        } catch (IOException e) {
            System.out.println("Gagal menulis katalog: " + e);
        }
    }

    // [Atribusi AI]: Pola try-catch satu catch untuk PustakaException dibantu AI;
    // pesan kesalahan ditampilkan ke pengguna, tidak ditelan.
    private static void cobaPinjam(KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
            System.out.println(" BERHASIL meminjam " + kode);
        } catch (PustakaException e) {
            System.out.println(" DITOLAK: " + e.getMessage());
        }
    }
}