package ui.ft.ccit.faculty.transaksi.barang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ui.ft.ccit.faculty.transaksi.barang.model.Pemasok;

@Repository
public interface PemasokRepository extends JpaRepository<Pemasok, String> {
}
