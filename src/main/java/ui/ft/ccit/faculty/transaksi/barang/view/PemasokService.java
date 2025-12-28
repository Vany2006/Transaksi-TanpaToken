package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.barang.repository.PemasokRepository;

@Service
public class PemasokService {

    private final PemasokRepository repository;

    public PemasokService(PemasokRepository repository) {
        this.repository = repository;
    }

    // =====================
    // GET ALL
    // =====================
    public List<Pemasok> getAll() {
        return repository.findAll();
    }

    // =====================
    // GET BY ID
    // =====================
    public Pemasok getById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException("Pemasok dengan ID " + id + " tidak ditemukan"));
    }

    // =====================
    // CREATE
    // =====================
    public Pemasok save(Pemasok pemasok) {
        if (repository.existsById(pemasok.getIdPemasok())) {
            throw new IllegalStateException(
                    "Pemasok dengan ID " + pemasok.getIdPemasok() + " sudah ada");
        }
        return repository.save(pemasok);
    }

    // =====================
    // UPDATE
    // =====================
    public Pemasok update(String id, Pemasok pemasok) {
        Pemasok existing = getById(id);

        existing.setNamaPemasok(pemasok.getNamaPemasok());
        existing.setAlamat(pemasok.getAlamat());
        existing.setTelepon(pemasok.getTelepon());
        existing.setEmail(pemasok.getEmail());

        return repository.save(existing);
    }

    // =====================
    // DELETE
    // =====================
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new IllegalStateException(
                    "Pemasok dengan ID " + id + " tidak ditemukan");
        }
        repository.deleteById(id);
    }
}

