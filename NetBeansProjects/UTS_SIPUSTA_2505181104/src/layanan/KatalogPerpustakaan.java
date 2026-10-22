package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Koleksi;

public class KatalogPerpustakaan {

    private final List<Koleksi> daftar = new ArrayList<>();
    private final Set<String> sedangDipinjam = new HashSet<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> semuaKoleksi() {
        return new ArrayList<>(daftar);
    }

    public Koleksi cari(String kode) {
        for (Koleksi k : daftar) {
            if (k.getKodeKoleksi().equals(kode)) {
                return k;
            }
        }
        return null;
    }

    // [Atribusi AI]: Method cetakStatus() dibantu AI agar seluruh koleksi
    // diproses polimorfik lewat tipe induk, tanpa pemeriksaan tipe satu per satu.
    public void cetakStatus() {
        for (Koleksi k : daftar) {
            String status = k.layakDipinjam() ? "Layak dipinjam" : "Tidak layak dipinjam";
            System.out.println(k.deskripsi() + " | " + status);
        }
    }

    // [Atribusi AI]: Method urut() dibantu AI agar aturan pengurutan dapat
    // diganti dari luar lewat Comparator, tanpa mengubah urutan daftar asli.
    public List<Koleksi> urut(Comparator<Koleksi> pembanding) {
        List<Koleksi> salinan = new ArrayList<>(daftar);
        salinan.sort(pembanding);
        return salinan;
    }

    // [Atribusi AI]: Method pinjam() dibantu AI untuk memeriksa kondisi sebelum
    // meminjam dan melempar eksepsi yang sesuai dengan keadaannya.
    public void pinjam(String kodeKoleksi) throws PustakaException {
        Koleksi k = cari(kodeKoleksi);
        if (k == null) {
            throw new PustakaException("Koleksi dengan kode " + kodeKoleksi
                    + " tidak ditemukan di katalog.");
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul());
        }
        if (sedangDipinjam.contains(kodeKoleksi)) {
            throw new KoleksiSedangDipinjamException(k.getJudul());
        }
        sedangDipinjam.add(kodeKoleksi);
    }
}