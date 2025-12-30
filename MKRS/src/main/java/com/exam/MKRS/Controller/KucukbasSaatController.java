package com.exam.MKRS.Controller;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.MKRS.Durum;
import com.exam.MKRS.entity.KucukbasSaat;
import com.exam.MKRS.service.KucukbasSaatService;

import java.util.List;


@RestController
@RequestMapping("/api/kucukbas-saat")
public class KucukbasSaatController {
    private  KucukbasSaatService saatService;

    public KucukbasSaatController(KucukbasSaatService saatService) {
        this.saatService = saatService;
    }

    @GetMapping("/saatleri-olustur")
    public void olusturSaatler() {
        saatService.SaatOlustur();
    }
    
    @GetMapping("/saatleri-getir")
    public List<KucukbasSaat> getAllSaatler() {
        return saatService.tumSaatleriGetir();
    }

    @GetMapping("/saate-gore")
    public List<KucukbasSaat> getSaatByTime(@RequestParam String saat) {
        LocalTime time = LocalTime.parse(saat);
        return saatService.saateGoreGetir(time);
    }

    @GetMapping("/bosta")
    public List<KucukbasSaat> getBostaSaatler() {
        return saatService.bostaGetir(Durum.BOŞTA);
    }
}
