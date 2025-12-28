package ui.ft.ccit.faculty.transaksi.barang.view;

import java.util.List;

import org.springframework.stereotype.Service;

import ui.ft.ccit.faculty.transaksi.barang.model.MetodePembayaran;
import ui.ft.ccit.faculty.transaksi.barang.repository.MetodePembayaranRepository;

@Service
public class MetodePembayaranService {

    private final MetodePembayaranRepository repository;

    public MetodePembayaranService(MetodePembayaranRepository repository) {
        this.repository = repository;
    }

    public List<MetodePembayaran> getAll() {
        return repository.findAll();
    }

    public List<MetodePembayaran> getByTransaksi(Long idTransaksi) {
        return repository.findByIdTransaksi(idTransaksi);
    }

    public MetodePembayaran getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MetodePembayaran save(MetodePembayaran pembayaran) {
        return repository.save(pembayaran);
    }

    public MetodePembayaran update(Long id, MetodePembayaran pembayaran) {
        pembayaran.setIdPembayaran(id);
        return repository.save(pembayaran);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

