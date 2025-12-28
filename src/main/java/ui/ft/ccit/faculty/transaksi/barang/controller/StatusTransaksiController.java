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

import ui.ft.ccit.faculty.transaksi.barang.model.StatusTransaksi;
import ui.ft.ccit.faculty.transaksi.barang.view.StatusTransaksiService;

@RestController
@RequestMapping("/api/status-transaksi")
public class StatusTransaksiController {

    private final StatusTransaksiService service;

    public StatusTransaksiController(StatusTransaksiService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<StatusTransaksi> list() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public StatusTransaksi get(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET BY ID TRANSAKSI
    @GetMapping("/transaksi/{idTransaksi}")
    public List<StatusTransaksi> byTransaksi(
            @PathVariable Long idTransaksi) {
        return service.getByTransaksi(idTransaksi);
    }

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusTransaksi create(
            @RequestBody StatusTransaksi status) {
        return service.save(status);
    }

    // PUT
    @PutMapping("/{id}")
    public StatusTransaksi update(
            @PathVariable Long id,
            @RequestBody StatusTransaksi status) {
        return service.update(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
