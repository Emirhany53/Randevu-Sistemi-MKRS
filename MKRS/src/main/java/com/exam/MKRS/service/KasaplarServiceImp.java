package com.exam.MKRS.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.exam.MKRS.DAO.KasapDAO;
import com.exam.MKRS.entity.Kasaplar;

import jakarta.transaction.Transactional;

@Service
public class KasaplarServiceImp implements KasaplarService {
    KasapDAO kasapD;

    public KasaplarServiceImp(KasapDAO thekasapD){
        kasapD = thekasapD;
    }

    @Override
    @Transactional
    public void kaydet(Kasaplar kasap){
        kasapD.kaydet(kasap);
    }

    @Override
    public List<Kasaplar> hepsiniGetir(){
        return kasapD.hepsiniGetir();
    }

    @Override 
    public List<Kasaplar> yetkiliyeGoreAra(String ytAd){
        return  kasapD.yetkiliyeGoreAra(ytAd);
    }
    @Override
    public List<Kasaplar> teleGoreAra(String ytTel){
        return kasapD.teleGoreAra(ytTel);
    }
    @Override
     public List<Kasaplar> aracHizmeteGoreAra(Boolean aracH){
        return kasapD.aracHizmeteGoreAra(aracH);
     }
     @Override
     @Transactional
     public void guncelle(Kasaplar kasap){
        kasapD.guncelle(kasap);
     }
     @Override
     @Transactional
     public void sil(Integer id){
        kasapD.sil(id);
     }
     @Override
     @Transactional
     public int hepsiniSil(){
        return kasapD.hepsiniSil();
     }
     @Override
     public Kasaplar idyeGoreGetir(Integer d){
       return kasapD.idyeGoreGetir(d);
     }

}
