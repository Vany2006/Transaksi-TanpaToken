package ui.ft.ccit.faculty.transaksi.barang.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.barang.model.MetodePembayaran;
import ui.ft.ccit.faculty.transaksi.barang.view.MetodePembayaranService;

@RestController
@RequestMapping("/api/pembayaran")
public class MetodePembayaranController {

    private final MetodePembayaranService service;

    public MetodePembayaranController(MetodePembayaranService service) {
        this.service = service;
    }

    @GetMapping
    public List<MetodePembayaran> getAll() {
        return service.getAll();
    }

    @GetMapping("/transaksi/{idTransaksi}")
    public List<MetodePembayaran> getByTransaksi(@PathVariable Long idTransaksi) {
        return service.getByTransaksi(idTransaksi);
    }

    @PostMapping
    public MetodePembayaran create(@RequestBody MetodePembayaran pembayaran) {
        return service.save(pembayaran);
    }

    @PutMapping("/{id}")
    public MetodePembayaran update(
            @PathVariable Long id,
            @RequestBody MetodePembayaran pembayaran) {
        return service.update(id, pembayaran);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

