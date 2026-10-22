
package model;

public abstract class Koleksi {

    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Method abstract untuk menentukan kelayakan peminjaman
    public abstract boolean layakDipinjam();

    // Menampilkan deskripsi koleksi
    public String deskripsi() {
        return kodeKoleksi + " - " + judul + " (" + tahunTerbit + ")";
    }

    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }
}
