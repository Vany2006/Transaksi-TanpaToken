package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ui.ft.ccit.faculty.transaksi.barang.model.Pelanggan;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, String> {

    // Cari pelanggan berdasarkan nama, tidak case-sensitive
    List<Pelanggan> findByNamaContainingIgnoreCase(String nama);

    // Cari pelanggan berdasarkan email, tidak case-sensitive
    List<Pelanggan> findByEmailContainingIgnoreCase(String email);

    // ✅ untuk validasi delete bulk
    long countByIdPelangganIn(Iterable<String> ids);

    // Ambil semua pelanggan aktif
    List<Pelanggan> findByStatusAktifTrue();
}
