package ui.ft.ccit.faculty.transaksi.barang.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {

    @Id
    @Column(name = "id_pelanggan", length = 4)
    private String idPelanggan;

    @Column(name = "nama", length = 255)
    private String nama;

    @Column(name = "alamat", length = 500)
    private String alamat;

    @Column(name = "telepon", length = 20)
    private String telepon;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "status_aktif", nullable = false)
    private Boolean statusAktif = true;

    protected Pelanggan() {
        // for JPA
    }

    public Pelanggan(String idPelanggan, String nama, String alamat, String telepon, String email) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.statusAktif = true;
    }

    public Pelanggan(String idPelanggan, String nama, String alamat, String telepon, String email, Boolean statusAktif) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.statusAktif = statusAktif;
    }

    // getters & setters

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(Boolean statusAktif) {
        this.statusAktif = statusAktif;
    }
}
