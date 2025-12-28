package ui.ft.ccit.faculty.transaksi.barang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.barang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.barang.view.JenisBarangService;

@RestController
@RequestMapping("/api/jenis-barang")
public class JenisBarangController {

    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    // =====================
    // GET ALL
    // =====================
    @GetMapping
    public ResponseEntity<List<JenisBarang>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // =====================
    // GET BY ID
    // =====================
    @GetMapping("/{id}")
    public ResponseEntity<JenisBarang> getById(@PathVariable Byte id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // =====================
    // CREATE
    // =====================
    @PostMapping
    public ResponseEntity<JenisBarang> create(
            @RequestBody JenisBarang jenisBarang) {

        JenisBarang saved = service.save(jenisBarang);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // =====================
    // UPDATE
    // =====================
    @PutMapping("/{id}")
    public ResponseEntity<JenisBarang> update(
            @PathVariable Byte id,
            @RequestBody JenisBarang jenisBarang) {

        JenisBarang updated = service.update(id, jenisBarang);
        return ResponseEntity.ok(updated);
    }

    // =====================
    // DELETE
    // =====================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Byte id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
