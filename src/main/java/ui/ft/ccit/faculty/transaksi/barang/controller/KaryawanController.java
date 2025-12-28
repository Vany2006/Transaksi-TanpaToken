package ui.ft.ccit.faculty.transaksi.barang.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.barang.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.barang.view.KaryawanService;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService service;

    public KaryawanController(KaryawanService service) {
        this.service = service;
    }

    // GET all karyawan
    @GetMapping
    public List<Karyawan> getAll() {
        return service.getAll();
    }

    // GET karyawan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Karyawan> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST add new karyawan
    @PostMapping
    public Karyawan create(@RequestBody Karyawan karyawan) {
        return service.save(karyawan);
    }

    // PUT update karyawan
    @PutMapping("/{id}")
    public ResponseEntity<Karyawan> update(@PathVariable String id, @RequestBody Karyawan karyawan) {
        return service.getById(id)
                .map(existing -> {
                    karyawan.setIdKaryawan(id);
                    Karyawan updated = service.save(karyawan);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE karyawan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.getById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // GET search by nama
    @GetMapping("/search/nama")
    public List<Karyawan> searchByNama(@RequestParam String nama) {
        return service.findByNama(nama);
    }

    // GET search by jabatan
    @GetMapping("/search/jabatan")
    public List<Karyawan> searchByJabatan(@RequestParam String jabatan) {
        return service.findByJabatan(jabatan);
    }

    // GET all active karyawan
    @GetMapping("/aktif")
    public List<Karyawan> getAllAktif() {
        return service.findAllAktif();
    }
}

