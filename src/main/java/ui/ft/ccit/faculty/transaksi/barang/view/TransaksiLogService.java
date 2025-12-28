package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.TransaksiLog;
import ui.ft.ccit.faculty.transaksi.barang.repository.TransaksiLogRepository;

@Service
public class TransaksiLogService {

    private final TransaksiLogRepository repository;

    public TransaksiLogService(TransaksiLogRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    public List<TransaksiLog> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public TransaksiLog getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // GET BY TRANSAKSI
    public List<TransaksiLog> getByTransaksi(Long idTransaksi) {
        return repository.findByIdTransaksi(idTransaksi);
    }

    // POST
    public TransaksiLog save(TransaksiLog log) {
        return repository.save(log);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

