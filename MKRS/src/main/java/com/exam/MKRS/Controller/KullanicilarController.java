package com.exam.MKRS.Controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.MKRS.entity.Kullanicilar;
import com.exam.MKRS.service.KullanicilarService;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullanicilarController {
    private  KullanicilarService kullaniciService;

    public KullanicilarController(KullanicilarService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @GetMapping("/kullanicilar")
    public List<Kullanicilar> getAllUsers() {
        return kullaniciService.k_hepsiniGetir();
    }

    @GetMapping("/{id}")
    public List<Kullanicilar> getUserById(@PathVariable Integer id) {
        return kullaniciService.k_idyeGoreGetir(id);
    }

    @PostMapping("/kulllanici-ekle")
    public void addUser(@RequestBody Kullanicilar kullanici) {
        kullaniciService.k_kaydet(kullanici);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody Kullanicilar kullanici) {
        kullanici.setklId(id);
        kullaniciService.k_guncelle(kullanici);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        kullaniciService.k_sil(id);
    }
}
