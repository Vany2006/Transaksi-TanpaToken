package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.barang.repository.TransaksiRepository;

@Service
public class TransaksiService {

    private final TransaksiRepository repository;

    public TransaksiService(TransaksiRepository repository) {
        this.repository = repository;
    }

    // ✅ INI YANG MEMPERBAIKI getAll()
    public List<Transaksi> getAll() {
        return repository.findAll();
    }

    public Transaksi getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Transaksi save(Transaksi transaksi) {
        return repository.save(transaksi);
    }

    public Transaksi update(Long id, Transaksi transaksi) {
    transaksi.setIdTransaksi(id);
    return repository.save(transaksi);
}

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

