package com.exam.MKRS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.MKRS.DAO.RezervasyonDAO;
import com.exam.MKRS.entity.Rezervasyon;

import jakarta.transaction.Transactional;

@Service
public class RezervasyonServiceImp implements RezervasyonService {
    RezervasyonDAO rezervasyonDAO;

    public RezervasyonServiceImp(RezervasyonDAO thRezervasyonDAO){
        rezervasyonDAO = thRezervasyonDAO;
    }
    @Override
    @Transactional
    public void randevuEkle(Rezervasyon rezervasyon){
        rezervasyonDAO.randevuEkle(rezervasyon);
    }
    @Override
    @Transactional
    public void randevuSil(Integer id){
        rezervasyonDAO.randevuSil(id);
    }
    @Override
    public List<Rezervasyon> randevuSirala(){
        return rezervasyonDAO.randevuSirala();
    }
    
}
