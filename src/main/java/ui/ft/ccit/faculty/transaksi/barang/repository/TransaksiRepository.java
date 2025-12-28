package ui.ft.ccit.faculty.transaksi.barang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ui.ft.ccit.faculty.transaksi.barang.model.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    // tidak perlu method tambahan dulu
}
