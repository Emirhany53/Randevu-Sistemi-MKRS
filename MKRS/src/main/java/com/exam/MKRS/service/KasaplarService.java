package com.exam.MKRS.service;

import java.util.List;

import com.exam.MKRS.entity.Kasaplar;


public interface KasaplarService {
    public void kaydet(Kasaplar kasap);
    public Kasaplar idyeGoreGetir(Integer d);
    public List<Kasaplar> hepsiniGetir();
    public List<Kasaplar> yetkiliyeGoreAra(String ytAd);
    public List<Kasaplar> teleGoreAra(String ytTel);
    public List<Kasaplar> aracHizmeteGoreAra(Boolean aracH);
    public void guncelle(Kasaplar kasap);
    public void sil(Integer id);
    public int hepsiniSil();
}
