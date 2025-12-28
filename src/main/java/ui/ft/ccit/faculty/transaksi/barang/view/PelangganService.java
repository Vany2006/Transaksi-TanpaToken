package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.barang.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.barang.repository.PelangganRepository;

@Service
@Transactional
public class PelangganService {

    private final PelangganRepository repository;

    public PelangganService(PelangganRepository repository) {
        this.repository = repository;
    }

    // Ambil semua pelanggan
    public List<Pelanggan> getAll() {
        return repository.findAll();
    }

    // Ambil pelanggan berdasarkan ID
    public Optional<Pelanggan> getById(String idPelanggan) {
        return repository.findById(idPelanggan);
    }

    // Simpan pelanggan baru atau update pelanggan
    public Pelanggan save(Pelanggan pelanggan) {
        return repository.save(pelanggan);
    }

    // Hapus pelanggan berdasarkan ID
    public void deleteById(String idPelanggan) {
        repository.deleteById(idPelanggan);
    }

    // Hapus banyak pelanggan sekaligus (bulk)
    public long countPelangganByIds(Iterable<String> ids) {
        return repository.countByIdPelangganIn(ids);
    }

    // Cari pelanggan berdasarkan nama
    public List<Pelanggan> findByNama(String nama) {
        return repository.findByNamaContainingIgnoreCase(nama);
    }

    // Cari pelanggan berdasarkan email
    public List<Pelanggan> findByEmail(String email) {
        return repository.findByEmailContainingIgnoreCase(email);
    }

    // Ambil semua pelanggan aktif
    public List<Pelanggan> findAllAktif() {
        return repository.findByStatusAktifTrue();
    }
}
