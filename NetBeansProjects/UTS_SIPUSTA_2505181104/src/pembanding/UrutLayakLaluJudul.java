package pembanding;

import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    // [Atribusi AI]: Method compare() dibantu AI untuk mengurutkan koleksi layak
    // pinjam lebih dulu, lalu berdasarkan judul (urutan alfabet).
    @Override
    public int compare(Koleksi a, Koleksi b) {
        int hasil = Boolean.compare(b.layakDipinjam(), a.layakDipinjam());
        if (hasil != 0) {
            return hasil;
        }
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}