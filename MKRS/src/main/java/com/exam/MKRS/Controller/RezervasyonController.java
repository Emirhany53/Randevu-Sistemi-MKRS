package com.exam.MKRS.Controller;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.MKRS.entity.Rezervasyon;
import com.exam.MKRS.service.RezervasyonService;

@RestController
@RequestMapping("/api/rezervasyon")
public class RezervasyonController {
     private  RezervasyonService rezervasyonService;

    public RezervasyonController(RezervasyonService rezervasyonService) {
        this.rezervasyonService = rezervasyonService;
    }

    @PostMapping("/rezervasyon-ekle")
    public void addRezervasyon(@RequestBody Rezervasyon r) {
        rezervasyonService.randevuEkle(r);
    }

    @DeleteMapping("/{id}")
    public void deleteRezervasyon(@PathVariable Integer id) {
        rezervasyonService.randevuSil(id);
    }
    @Lazy
    @GetMapping("/rezervasyonlari-goster")
    public List<Rezervasyon> getAllRezervasyon() {
        return rezervasyonService.randevuSirala();
    }
}
