package com.exam.MKRS.DAO;
import java.util.List;

import com.exam.MKRS.Durum;
import com.exam.MKRS.entity.KucukbasSaat;

import java.time.LocalTime;

public interface KucukbasSaatDAO {
    void SaatOlustur();
    List<KucukbasSaat> tumSaatleriGetir();
    List<KucukbasSaat> saateGoreGetir(LocalTime st);
    List<KucukbasSaat> bostaGetir(Durum durum);

    
}
