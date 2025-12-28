package ui.ft.ccit.faculty.transaksi.barang.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @Column(name = "id_karyawan", length = 4)
    private String idKaryawan;

    @Column(name = "nama", length = 255)
    private String nama;

    @Column(name = "jabatan", length = 100)
    private String jabatan;

    @Column(name = "gaji")
    private Double gaji;

    @Column(name = "status_aktif", nullable = false)
    private Boolean statusAktif = true;

    protected Karyawan() {
        // for JPA
    }

    public Karyawan(String idKaryawan, String nama, String jabatan, Double gaji) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.statusAktif = true;
    }

    public Karyawan(String idKaryawan, String nama, String jabatan, Double gaji, Boolean statusAktif) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.statusAktif = statusAktif;
    }

    // getters & setters

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Double getGaji() {
        return gaji;
    }

    public void setGaji(Double gaji) {
        this.gaji = gaji;
    }

    public Boolean getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(Boolean statusAktif) {
        this.statusAktif = statusAktif;
    }
}
