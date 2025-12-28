package ui.ft.ccit.faculty.transaksi.barang;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.barang.repository.BarangRepository;

@SpringBootTest
class BarangRepositoryTest {

    @Autowired
    private BarangRepository barangRepository;

    @Test
    @Transactional
    @Rollback
    void saveAndFindById_shouldPersistAndLoadBarang() {
        Barang barang = new Barang(
                "T001",
                "Sabun Mandi",
                (short) 10,
                5000.0,
                20.0,
                0.0,
                (byte) 103,
                "S003");

        barangRepository.save(barang);

        var found = barangRepository.findById("T001");

        assertThat(found).isPresent();
        assertThat(found.get().getNama()).isEqualTo("Sabun Mandi");
        assertThat(found.get().getStok()).isEqualTo((short) 10);
    }

    @Test
    @Transactional
    @Rollback
    void findByNamaContainingIgnoreCase_shouldReturnMatchingRows() {
        // gunakan ID berbeda agar aman jika test dijalankan bersamaan
        barangRepository.save(new Barang("T002", "Shampoo Wangi", (short) 5, 15000.0, 25.0, 0.0, (byte) 103, "S003"));
        barangRepository.save(new Barang("T003", "Sabun Cuci", (short) 20, 3000.0, 15.0, 0.0, (byte) 103, "S003"));

        List<Barang> hasil = barangRepository.findByNamaContainingIgnoreCase("sham");

        assertThat(hasil)
                .hasSize(1)
                .first()
                .extracting(Barang::getIdBarang)
                .isEqualTo("T002");
    }

    @Test
    @Transactional
    @Rollback
    void countByIdBarangIn_shouldReturnCorrectCount() {
        barangRepository.save(new Barang("T004", "Minyak Goreng", (short) 50, 12000.0, 10.0, 0.0, (byte) 103, "S004"));
        barangRepository.save(new Barang("T005", "Gula Pasir", (short) 30, 15000.0, 12.0, 0.0, (byte) 103, "S004"));

        long count = barangRepository.countByIdBarangIn(List.of("T004", "T005", "T999")); // T999 tidak ada

        assertThat(count).isEqualTo(2);
    }
}
