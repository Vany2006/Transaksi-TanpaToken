package ui.ft.ccit.faculty.transaksi.barang.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaksi_detail")
public class TransaksiDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    private Long idDetail;

    @Column(name = "id_transaksi", nullable = false)
    private Long idTransaksi;

    @Column(name = "id_barang", length = 4, nullable = false)
    private String idBarang;

    @Column(name = "jumlah", nullable = false)
    private Short jumlah;

    @Column(name = "harga", nullable = false)
    private Double harga;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    // ✅ wajib untuk JPA
    protected TransaksiDetail() {}

    // ✅ constructor bisnis
    public TransaksiDetail(Long idTransaksi, String idBarang, Short jumlah, Double harga) {
        this.idTransaksi = idTransaksi;
        this.idBarang = idBarang;
        this.jumlah = jumlah;
        this.harga = harga;
        hitungSubtotal();
    }

    // ===== GETTER =====

    public Long getIdDetail() {
        return idDetail;
    }

    public Long getIdTransaksi() {
        return idTransaksi;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public Short getJumlah() {
        return jumlah;
    }

    public Double getHarga() {
        return harga;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    // ===== SETTER (tanpa setIdDetail, sesuai best practice) =====

    public void setIdTransaksi(Long idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public void setJumlah(Short jumlah) {
        this.jumlah = jumlah;
        hitungSubtotal();
    }

    public void setHarga(Double harga) {
        this.harga = harga;
        hitungSubtotal();
    }

    // ===== LOGIKA INTERNAL =====
    private void hitungSubtotal() {
        if (jumlah != null && harga != null) {
            this.subtotal = jumlah * harga;
        }
    }
}
