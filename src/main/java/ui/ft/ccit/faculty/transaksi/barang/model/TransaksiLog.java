package ui.ft.ccit.faculty.transaksi.barang.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaksi_log")
public class TransaksiLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Long idLog;

    @Column(name = "id_transaksi", nullable = false)
    private Long idTransaksi;

    @Column(name = "aksi", length = 50, nullable = false)
    private String aksi;
    // CREATE, UPDATE, DELETE, PAYMENT, STATUS_CHANGE

    @Column(name = "keterangan", length = 150)
    private String keterangan;

    @Column(name = "waktu", nullable = false)
    private LocalDateTime waktu;

    protected TransaksiLog() {}

    public TransaksiLog(Long idTransaksi, String aksi, String keterangan) {
        this.idTransaksi = idTransaksi;
        this.aksi = aksi;
        this.keterangan = keterangan;
        this.waktu = LocalDateTime.now();
    }

    // ===== GETTER & SETTER =====

    public Long getIdLog() {
        return idLog;
    }

    public Long getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Long idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getAksi() {
        return aksi;
    }

    public void setAksi(String aksi) {
        this.aksi = aksi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }
}

