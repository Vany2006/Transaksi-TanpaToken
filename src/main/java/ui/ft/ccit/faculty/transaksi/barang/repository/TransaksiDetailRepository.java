package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.barang.model.TransaksiDetail;

public interface TransaksiDetailRepository extends JpaRepository<TransaksiDetail, Long> {

    List<TransaksiDetail> findByIdTransaksi(Long idTransaksi);
}
