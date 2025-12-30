package com.exam.MKRS.service;
import java.util.List;

import com.exam.MKRS.entity.Rezervasyon;


public interface RezervasyonService {
    public void randevuEkle(Rezervasyon rezervasyon);
    public void randevuSil(Integer id);
    public List<Rezervasyon> randevuSirala();
} 
