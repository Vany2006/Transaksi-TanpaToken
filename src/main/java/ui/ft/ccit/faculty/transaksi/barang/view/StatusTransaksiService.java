package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.StatusTransaksi;
import ui.ft.ccit.faculty.transaksi.barang.repository.StatusTransaksiRepository;

@Service
public class StatusTransaksiService {

    private final StatusTransaksiRepository repository;

    public StatusTransaksiService(StatusTransaksiRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    public List<StatusTransaksi> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public StatusTransaksi getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // GET BY ID TRANSAKSI
    public List<StatusTransaksi> getByTransaksi(Long idTransaksi) {
        return repository.findByIdTransaksi(idTransaksi);
    }

    // POST
    public StatusTransaksi save(StatusTransaksi status) {
        return repository.save(status);
    }

    // PUT
    public StatusTransaksi update(Long id, StatusTransaksi status) {
        StatusTransaksi existing = getById(id);
        if (existing == null) {
            return null;
        }

        existing.setStatus(status.getStatus());
        existing.setKeterangan(status.getKeterangan());
        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
