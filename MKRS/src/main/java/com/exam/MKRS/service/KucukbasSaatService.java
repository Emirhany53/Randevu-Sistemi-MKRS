package com.exam.MKRS.service;

import java.time.LocalTime;
import java.util.List;

import com.exam.MKRS.Durum;
import com.exam.MKRS.entity.KucukbasSaat;

public interface KucukbasSaatService {
    void SaatOlustur();
    List<KucukbasSaat> tumSaatleriGetir();
    List<KucukbasSaat> saateGoreGetir(LocalTime st);
    List<KucukbasSaat> bostaGetir(Durum durum);
    
}