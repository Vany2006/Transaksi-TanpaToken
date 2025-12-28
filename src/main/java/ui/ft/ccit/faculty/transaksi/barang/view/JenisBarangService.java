package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.barang.repository.JenisBarangRepository;

@Service
public class JenisBarangService {

    private final JenisBarangRepository repository;

    public JenisBarangService(JenisBarangRepository repository) {
        this.repository = repository;
    }

    // =====================
    // GET ALL
    // =====================
    public List<JenisBarang> getAll() {
        return repository.findAll();
    }

    // =====================
    // GET BY ID
    // =====================
   public JenisBarang getById(Byte id) {
    return repository.findById(id)
            .orElseThrow(() ->
                    new IllegalStateException(
                            "Jenis Barang dengan ID " + id + " tidak ditemukan"));
}

    // =====================
    // CREATE
    // =====================
    public JenisBarang save(JenisBarang jenisBarang) {
        return repository.save(jenisBarang);
    }

    // =====================
    // UPDATE
    // =====================
    public JenisBarang update(Byte id, JenisBarang jenisBarang) {
        JenisBarang existing = getById(id);
        existing.setNamaJenis(jenisBarang.getNamaJenis());
        return repository.save(existing);
    }

    // =====================
    // DELETE
    // =====================
    public void delete(Byte id) {
        if (!repository.existsById(id)) {
            throw new IllegalStateException(
                    "Jenis Barang dengan ID " + id + " tidak ditemukan");
        }
        repository.deleteById(id);
    }
}
