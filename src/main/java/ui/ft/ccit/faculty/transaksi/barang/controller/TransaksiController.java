package ui.ft.ccit.faculty.transaksi.barang.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.barang.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.barang.view.TransaksiService;

import java.util.List;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService service;

    public TransaksiController(TransaksiService service) {
        this.service = service;
    }

    // GET semua transaksi
    @GetMapping
    public List<Transaksi> list() {
        return service.getAll();
    }

    // GET transaksi by id
    @GetMapping("/{id}")
    public Transaksi get(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST transaksi baru
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaksi create(@RequestBody Transaksi transaksi) {
        return service.save(transaksi);
    }

    // PUT update transaksi
    @PutMapping("/{id}")
    public Transaksi update(
            @PathVariable Long id,
            @RequestBody Transaksi transaksi
    ) {
        return service.update(id, transaksi);
    }

    // DELETE transaksi
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
