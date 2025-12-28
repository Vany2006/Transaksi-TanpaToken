package ui.ft.ccit.faculty.transaksi.barang.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Long idTransaksi;

    @Column(name = "id_barang", length = 4, nullable = false)
    private String idBarang;

    @Column(name = "id_jenis_brg", nullable = false)
    private Byte idJenisBarang;

    @Column(name = "id_pemasok", length = 4, nullable = false)
    private String idPemasok;

    @Column(name = "jumlah", nullable = false)
    private Short jumlah;

    @Column(name = "harga", nullable = false)
    private Double harga;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "tanggal_transaksi", nullable = false)
    private LocalDateTime tanggalTransaksi;

    protected Transaksi() {
        // untuk JPA
    }

    public Transaksi(
            String idBarang,
            Byte idJenisBarang,
            String idPemasok,
            Short jumlah,
            Double harga
    ) {
        this.idBarang = idBarang;
        this.idJenisBarang = idJenisBarang;
        this.idPemasok = idPemasok;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = jumlah * harga;
        this.tanggalTransaksi = LocalDateTime.now();
    }

    // ===== getter & setter =====

    public Long getIdTransaksi() {
        return idTransaksi;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public Byte getIdJenisBarang() {
        return idJenisBarang;
    }

    public void setIdJenisBarang(Byte idJenisBarang) {
        this.idJenisBarang = idJenisBarang;
    }

    public String getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(String idPemasok) {
        this.idPemasok = idPemasok;
    }

    public void setIdTransaksi(Long idTransaksi) {
    this.idTransaksi = idTransaksi;
}

    public Short getJumlah() {
        return jumlah;
    }

    public void setJumlah(Short jumlah) {
        this.jumlah = jumlah;
        hitungTotal();
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
        hitungTotal();
    }

    public Double getTotal() {
        return total;
    }

    public LocalDateTime getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    private void hitungTotal() {
        if (jumlah != null && harga != null) {
            this.total = jumlah * harga;
        }
    }
}
