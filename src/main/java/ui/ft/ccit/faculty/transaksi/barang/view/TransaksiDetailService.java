package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.TransaksiDetail;
import ui.ft.ccit.faculty.transaksi.barang.repository.TransaksiDetailRepository;

@Service
public class TransaksiDetailService {

    private final TransaksiDetailRepository repository;

    public TransaksiDetailService(TransaksiDetailRepository repository) {
        this.repository = repository;
    }

    public List<TransaksiDetail> getByTransaksi(Long idTransaksi) {
        return repository.findByIdTransaksi(idTransaksi);
    }

    public TransaksiDetail save(TransaksiDetail detail) {
        return repository.save(detail);
    }
}

