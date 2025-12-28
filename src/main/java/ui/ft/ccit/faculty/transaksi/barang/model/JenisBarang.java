package ui.ft.ccit.faculty.transaksi.barang.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jenis_barang")
public class JenisBarang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // kalau tabel kamu auto increment
    @Column(name = "id_jenis_brg")
    private Byte idJenisBarang;

    @Column(name = "nama_jenis_brg", length = 255)
    private String namaJenis;

    protected JenisBarang() {
        // untuk JPA
    }

    public JenisBarang(Byte idJenisBarang, String namaJenis) {
        this.idJenisBarang = idJenisBarang;
        this.namaJenis = namaJenis;
    }

    // === GETTERS & SETTERS ===

    public Byte getIdJenisBarang() {
        return idJenisBarang;
    }

    public void setIdJenisBarang(Byte idJenisBarang) {
        this.idJenisBarang = idJenisBarang;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

}
