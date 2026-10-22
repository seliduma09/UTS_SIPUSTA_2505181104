
package model;

public class BukuCetak extends Koleksi implements Terarsip {

    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit,
                     int jumlahHalaman, String nomorRak,
                     boolean sedangDiperbaiki) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + jumlahHalaman
                + " halaman, rak " + nomorRak;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public int lokasiLantai() {
        if (nomorRak == null || nomorRak.isEmpty()) {
            return 0;
        }

        char huruf = Character.toUpperCase(nomorRak.charAt(0));

        if (huruf < 'A' || huruf > 'Z') {
            return 0;
        }

        return huruf - 'A' + 1;
    }
}
