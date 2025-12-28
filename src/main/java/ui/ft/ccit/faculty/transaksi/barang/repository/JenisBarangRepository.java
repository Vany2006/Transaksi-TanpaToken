package ui.ft.ccit.faculty.transaksi.barang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.barang.model.JenisBarang;

public interface JenisBarangRepository
        extends JpaRepository<JenisBarang, Byte> {
}
