package com.exam.MKRS.service;

import java.util.List;

import com.exam.MKRS.entity.Kullanicilar;

public interface KullanicilarService {
     public void k_kaydet(Kullanicilar kullanici);
    public List<Kullanicilar> k_idyeGoreGetir(Integer di);
    public List<Kullanicilar> k_hepsiniGetir();
    public void k_guncelle(Kullanicilar kullanici);
    public void k_sil(Integer id);
    public int k_hepsiniSil();
}
