
package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {

    public KoleksiTidakLayakException(String judul) {
        super("Koleksi \"" + judul + "\" belum bisa dipinjam saat ini. "
                + "Silakan pilih koleksi lain.");
    }
}
