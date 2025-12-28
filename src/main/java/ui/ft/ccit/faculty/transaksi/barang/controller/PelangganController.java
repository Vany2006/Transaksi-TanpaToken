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

import ui.ft.ccit.faculty.transaksi.barang.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.barang.view.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganService service;

    public PelangganController(PelangganService service) {
        this.service = service;
    }

    // GET all pelanggan
    @GetMapping
    public List<Pelanggan> getAll() {
        return service.getAll();
    }

    // GET pelanggan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pelanggan> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST add new pelanggan
    @PostMapping
    public Pelanggan create(@RequestBody Pelanggan pelanggan) {
        return service.save(pelanggan);
    }

    // PUT update pelanggan
    @PutMapping("/{id}")
    public ResponseEntity<Pelanggan> update(@PathVariable String id, @RequestBody Pelanggan pelanggan) {
        return service.getById(id)
                .map(existing -> {
                    pelanggan.setIdPelanggan(id);
                    Pelanggan updated = service.save(pelanggan);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE pelanggan by ID
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
    public List<Pelanggan> searchByNama(@RequestParam String nama) {
        return service.findByNama(nama);
    }

    // GET search by email
    @GetMapping("/search/email")
    public List<Pelanggan> searchByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    // GET all active pelanggan
    @GetMapping("/aktif")
    public List<Pelanggan> getAllAktif() {
        return service.findAllAktif();
    }
}
