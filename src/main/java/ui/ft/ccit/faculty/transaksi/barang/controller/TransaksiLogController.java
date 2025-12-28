package ui.ft.ccit.faculty.transaksi.barang.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.barang.model.TransaksiLog;
import ui.ft.ccit.faculty.transaksi.barang.view.TransaksiLogService;

@RestController
@RequestMapping("/api/transaksi-log")
public class TransaksiLogController {

    private final TransaksiLogService service;

    public TransaksiLogController(TransaksiLogService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<TransaksiLog> list() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TransaksiLog get(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET BY TRANSAKSI
    @GetMapping("/transaksi/{idTransaksi}")
    public List<TransaksiLog> byTransaksi(
            @PathVariable Long idTransaksi) {
        return service.getByTransaksi(idTransaksi);
    }

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransaksiLog create(
            @RequestBody TransaksiLog log) {
        return service.save(log);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
