
package model;

public class Majalah extends Koleksi implements Terarsip {

    private int edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;
    private String nomorRak;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit,
                   int edisi, String bulanTerbit, boolean edisiTerbaru,
                   String nomorRak) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | edisi " + edisi
                + ", " + bulanTerbit + ", rak " + nomorRak;
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
