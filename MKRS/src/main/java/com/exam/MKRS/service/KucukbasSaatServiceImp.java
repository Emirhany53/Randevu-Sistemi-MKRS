package com.exam.MKRS.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.MKRS.Durum;
import com.exam.MKRS.DAO.KucukbasSaatDAO;
import com.exam.MKRS.entity.KucukbasSaat;

import jakarta.transaction.Transactional;


@Service
public class KucukbasSaatServiceImp implements KucukbasSaatService{
    private KucukbasSaatDAO kucukbasSaatDAO;
    
    public KucukbasSaatServiceImp(KucukbasSaatDAO kucukbasSaatDAO) {
        this.kucukbasSaatDAO = kucukbasSaatDAO;
    }


    @Transactional
    @Override
    public void SaatOlustur(){
        kucukbasSaatDAO.SaatOlustur();
    }
    @Override
    public List<KucukbasSaat> tumSaatleriGetir(){
        return kucukbasSaatDAO.tumSaatleriGetir();
    }
    @Override
    public List<KucukbasSaat> saateGoreGetir(LocalTime st){
        return kucukbasSaatDAO.saateGoreGetir(st);
    }
    @Override
    public List<KucukbasSaat> bostaGetir(Durum durum){
        return kucukbasSaatDAO.bostaGetir(durum);
    }
    
}
