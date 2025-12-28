package ui.ft.ccit.faculty.transaksi.barang.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_transaksi")
public class StatusTransaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long idStatus;

    @Column(name = "id_transaksi", nullable = false)
    private Long idTransaksi;

    @Column(name = "status", length = 30, nullable = false)
    private String status;
    // CREATED, PAID, CANCELED, COMPLETED

    @Column(name = "keterangan", length = 100)
    private String keterangan;

    @Column(name = "waktu", nullable = false)
    private LocalDateTime waktu;

    protected StatusTransaksi() {}

    public StatusTransaksi(Long idTransaksi, String status, String keterangan) {
        this.idTransaksi = idTransaksi;
        this.status = status;
        this.keterangan = keterangan;
        this.waktu = LocalDateTime.now();
    }

    // ===== GETTER & SETTER =====

    public Long getIdStatus() {
        return idStatus;
    }

    public Long getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Long idTransaksi) {
        this.idTransaksi = idTransaksi;
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

    public LocalDateTime getWaktu() {
        return waktu;
    }
}

