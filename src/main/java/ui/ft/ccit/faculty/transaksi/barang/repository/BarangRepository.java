package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ui.ft.ccit.faculty.transaksi.barang.model.Barang;

@Repository
public interface BarangRepository extends JpaRepository<Barang, String> {

    List<Barang> findByNamaContainingIgnoreCase(String nama);

    // ✅ untuk validasi delete bulk
    long countByIdBarangIn(Iterable<String> ids);
}
