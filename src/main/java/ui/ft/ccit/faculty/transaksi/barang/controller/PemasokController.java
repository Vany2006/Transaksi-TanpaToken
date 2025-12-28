package ui.ft.ccit.faculty.transaksi.barang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.barang.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.barang.view.PemasokService;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    private final PemasokService service;

    public PemasokController(PemasokService service) {
        this.service = service;
    }

    // =====================
    // GET ALL PEMASOK
    // =====================
    @GetMapping
    public List<Pemasok> list() {
        return service.getAll();
    }

    // =====================
    // GET PEMASOK BY ID
    // =====================
    @GetMapping("/{id}")
    public Pemasok get(@PathVariable String id) {
        return service.getById(id);
    }

    // =====================
    // CREATE PEMASOK
    // =====================
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pemasok create(@RequestBody Pemasok pemasok) {
        return service.save(pemasok);
    }

    // =====================
    // UPDATE PEMASOK
    // =====================
    @PutMapping("/{id}")
    public Pemasok update(
            @PathVariable String id,
            @RequestBody Pemasok pemasok) {
        return service.update(id, pemasok);
    }

    // =====================
    // DELETE PEMASOK
    // =====================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
