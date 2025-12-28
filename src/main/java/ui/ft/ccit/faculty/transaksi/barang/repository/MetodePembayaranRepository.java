package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.barang.model.MetodePembayaran;

public interface MetodePembayaranRepository
        extends JpaRepository<MetodePembayaran, Long> {

    List<MetodePembayaran> findByIdTransaksi(Long idTransaksi);
}

