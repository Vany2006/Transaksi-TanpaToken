package ui.ft.ccit.faculty.transaksi.barang.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metode_pembayaran")
public class MetodePembayaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pembayaran")
    private Long idPembayaran;

    @Column(name = "id_transaksi", nullable = false)
    private Long idTransaksi;

    @Column(name = "jenis_pembayaran", length = 30, nullable = false)
    private String jenisPembayaran;

    @Column(name = "nominal", nullable = false)
    private Double nominal;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "keterangan", length = 100)
    private String keterangan;

    protected MetodePembayaran() {}

    public MetodePembayaran(
            Long idTransaksi,
            String jenisPembayaran,
            Double nominal,
            String status,
            String keterangan
    ) {
        this.idTransaksi = idTransaksi;
        this.jenisPembayaran = jenisPembayaran;
        this.nominal = nominal;
        this.status = status;
        this.keterangan = keterangan;
    }

    // ===== GETTER & SETTER =====

    public Long getIdPembayaran() {
        return idPembayaran;
    }

    // ✅ INI YANG MEMPERBAIKI ERROR setIdPembayaran
    public void setIdPembayaran(Long idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public Long getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Long idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public Double getNominal() {
        return nominal;
    }

    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
