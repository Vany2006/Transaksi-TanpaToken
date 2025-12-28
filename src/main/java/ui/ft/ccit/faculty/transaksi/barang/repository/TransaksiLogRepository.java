package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.barang.model.TransaksiLog;

public interface TransaksiLogRepository
        extends JpaRepository<TransaksiLog, Long> {

    List<TransaksiLog> findByIdTransaksi(Long idTransaksi);
}
