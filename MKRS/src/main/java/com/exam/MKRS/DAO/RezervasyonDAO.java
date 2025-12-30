package com.exam.MKRS.DAO;
import java.util.List;

import com.exam.MKRS.entity.Rezervasyon;

public interface RezervasyonDAO {
    public void randevuEkle(Rezervasyon rezervasyon);
    public void randevuSil(Integer id);
    public List<Rezervasyon> randevuSirala();
    
} 
