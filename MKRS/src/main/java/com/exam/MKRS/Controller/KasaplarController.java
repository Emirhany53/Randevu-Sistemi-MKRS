package com.exam.MKRS.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.MKRS.entity.Kasaplar;
import com.exam.MKRS.service.KasaplarService;

import java.util.List;

@RestController
@RequestMapping("/api/kasaplar")
public class KasaplarController {

    private  KasaplarService kasapService;

    public KasaplarController(KasaplarService kasapService) {
        this.kasapService = kasapService;
    }

    @GetMapping("/kasaplari-getir")
    public List<Kasaplar> getAllKasaplar() {
        return kasapService.hepsiniGetir();
    }

    @GetMapping("/{id}")
    public Kasaplar getKasapById(@PathVariable Integer id) {
        return kasapService.idyeGoreGetir(id);
    }

    @PostMapping("/kasap-ekle")
    public void addKasap(@RequestBody Kasaplar kasap) {
        kasapService.kaydet(kasap);
    }

    @PutMapping("/{id}")
    public void updateKasap(@PathVariable Integer id, @RequestBody Kasaplar kasap) {
        kasap.setId(id);
        kasapService.guncelle(kasap);
    }

    @DeleteMapping("/{id}")
    public void deleteKasap(@PathVariable Integer id) {
        kasapService.sil(id);
    }

}
