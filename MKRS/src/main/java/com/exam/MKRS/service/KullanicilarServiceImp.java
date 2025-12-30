package com.exam.MKRS.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.exam.MKRS.DAO.KullaniciDAO;
import com.exam.MKRS.entity.Kullanicilar;

import jakarta.transaction.Transactional;

@Service
public class KullanicilarServiceImp implements KullanicilarService {
    KullaniciDAO kullaniciD;

    public KullanicilarServiceImp(KullaniciDAO thekullaniciD){
        kullaniciD = thekullaniciD;
    }
    @Override
    @Transactional
    public void k_kaydet(Kullanicilar kullanici){
        kullaniciD.k_kaydet(kullanici);
    }
    @Override
    public List<Kullanicilar> k_idyeGoreGetir(Integer di){
        return kullaniciD.k_idyeGoreGetir(di);
    }
    @Override
    public List<Kullanicilar> k_hepsiniGetir(){
        return kullaniciD.k_hepsiniGetir();
    }
    @Override
    public void k_guncelle(Kullanicilar kullanici){
        kullaniciD.k_guncelle(kullanici);
    }
    @Override
    public void k_sil(Integer id){
       kullaniciD.k_sil(id);
    }
    @Override
    public int k_hepsiniSil(){
        return kullaniciD.k_hepsiniSil();
    }

}
