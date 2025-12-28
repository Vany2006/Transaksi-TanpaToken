package ui.ft.ccit.faculty.transaksi.barang.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.barang.model.TransaksiDetail;
import ui.ft.ccit.faculty.transaksi.barang.view.TransaksiDetailService;

@RestController
@RequestMapping("/api/transaksi-detail")
public class TransaksiDetailController {

    private final TransaksiDetailService service;

    public TransaksiDetailController(TransaksiDetailService service) {
        this.service = service;
    }

    @GetMapping("/{idTransaksi}")
    public List<TransaksiDetail> getByTransaksi(@PathVariable Long idTransaksi) {
        return service.getByTransaksi(idTransaksi);
    }

    @PostMapping
    public TransaksiDetail create(@RequestBody TransaksiDetail detail) {
        return service.save(detail);
    }
}
