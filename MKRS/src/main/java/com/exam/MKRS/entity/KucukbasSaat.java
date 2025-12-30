package com.exam.MKRS.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalTime;

import org.springframework.context.annotation.Lazy;

import com.exam.MKRS.Durum;

@Entity
@Table(name = "saat_kucukbas")
public class KucukbasSaat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column
    private int id;


    @Column(name = "saat",nullable = false)
    private LocalTime saat;

    @Enumerated(EnumType.STRING)
    @Column(name = "durum", nullable = false)
    private Durum durum;
    
    @Lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kasap_dukkan_id",nullable = false)
    private Kasaplar kasap;

    public KucukbasSaat(){}

    public KucukbasSaat(LocalTime saat,Durum durum){
        this.durum = durum;
        this.saat = saat;
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public Durum getDurum(){return durum;}
    public void setDurum(Durum durum){this.durum=durum;}

    public LocalTime getSaat(){return saat;}
    public void setSaat(LocalTime saat){this.saat = saat;}

    public Kasaplar getKasap(){return kasap;}
    public void setKasap(Kasaplar kasap){this.kasap=kasap;}

}
