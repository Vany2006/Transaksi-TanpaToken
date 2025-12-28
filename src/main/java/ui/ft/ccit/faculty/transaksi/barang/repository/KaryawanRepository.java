package ui.ft.ccit.faculty.transaksi.barang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ui.ft.ccit.faculty.transaksi.barang.model.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, String> {

    // Cari karyawan berdasarkan nama, tidak case-sensitive
    List<Karyawan> findByNamaContainingIgnoreCase(String nama);

    // Cari karyawan berdasarkan jabatan, tidak case-sensitive
    List<Karyawan> findByJabatanContainingIgnoreCase(String jabatan);

    // ✅ untuk validasi delete bulk
    long countByIdKaryawanIn(Iterable<String> ids);

    // Contoh tambahan: cari karyawan aktif
    List<Karyawan> findByStatusAktifTrue();
}

