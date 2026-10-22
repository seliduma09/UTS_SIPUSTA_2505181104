
package berkas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {

    public void tulisKatalog(String namaBerkas, List<Koleksi> daftar)
            throws IOException {

        try (PrintWriter tulis = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(namaBerkas, StandardCharsets.UTF_8)))) {

            tulis.println("KATALOG PERPUSTAKAAN POLITEKNIK NEGERI MEDAN");
            tulis.println("Tanggal cetak: " + LocalDate.now());
            tulis.println();

            tulis.printf("%-10s %-28s %-14s %-6s %-20s%n",
                    "KODE", "JUDUL", "JENIS", "TAHUN", "STATUS");

            tulis.println("-".repeat(82));

            for (Koleksi k : daftar) {
                tulis.printf("%-10s %-28s %-14s %-6d %-20s%n",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getClass().getSimpleName(),
                        k.getTahunTerbit(),
                        k.layakDipinjam()
                                ? "Layak dipinjam"
                                : "Tidak layak");
            }

            tulis.println();
            tulis.println("Jumlah koleksi: " + daftar.size());
        }
    }
}
