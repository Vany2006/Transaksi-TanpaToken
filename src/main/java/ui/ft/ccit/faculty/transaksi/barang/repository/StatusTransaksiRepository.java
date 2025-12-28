package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.barang.model.StatusTransaksi;

public interface StatusTransaksiRepository
        extends JpaRepository<StatusTransaksi, Long> {

    List<StatusTransaksi> findByIdTransaksi(Long idTransaksi);
}
