package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.barang.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.barang.repository.KaryawanRepository;

@Service
@Transactional
public class KaryawanService {

    private final KaryawanRepository repository;

    public KaryawanService(KaryawanRepository repository) {
        this.repository = repository;
    }

    // Ambil semua karyawan
    public List<Karyawan> getAll() {
        return repository.findAll();
    }

    // Ambil karyawan berdasarkan ID
    public Optional<Karyawan> getById(String idKaryawan) {
        return repository.findById(idKaryawan);
    }

    // Simpan karyawan baru atau update karyawan
    public Karyawan save(Karyawan karyawan) {
        return repository.save(karyawan);
    }

    // Hapus karyawan berdasarkan ID
    public void deleteById(String idKaryawan) {
        repository.deleteById(idKaryawan);
    }

    // Hapus banyak karyawan sekaligus (bulk)
    public long countKaryawanByIds(Iterable<String> ids) {
        return repository.countByIdKaryawanIn(ids);
    }

    // Cari karyawan berdasarkan nama
    public List<Karyawan> findByNama(String nama) {
        return repository.findByNamaContainingIgnoreCase(nama);
    }

    // Cari karyawan berdasarkan jabatan
    public List<Karyawan> findByJabatan(String jabatan) {
        return repository.findByJabatanContainingIgnoreCase(jabatan);
    }

    // Ambil semua karyawan aktif
    public List<Karyawan> findAllAktif() {
        return repository.findByStatusAktifTrue();
    }
}
