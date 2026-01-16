package com.exam.MKRS.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
//EMİRHAN 31
//import org.hibernate.annotations.processing.Pattern;

import jakarta.persistence.Column;
//import jakarta.persistence.ColumnResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;



@Entity
@Table(name = "kasap_dukkan")
public class Kasaplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kasap_dukkan_id")
    private int id;

    @Column(name = "ad")
    private String dukkanAd;

    @Column(name = "adres")
    private String adres;

    @Column(name = "yetkili_ad")
    private String yetkiliAd;

    @Column(name = "yetkili_tel_no")
    private String yetkiliTel;

    @Column(name = "ucret_kucukbas",precision = 10,scale = 2)
    private BigDecimal kucukbasFiyat;

    @Column(name = "arac_hizmeti")
    private Boolean aracHizmeti;

    @Column(name = "arac_hizmet_ucreti" , precision = 10,scale = 2)
    private BigDecimal aracUcret;

    @OneToMany(mappedBy = "kasap",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<KucukbasSaat> kucukbasSaats = new ArrayList<>();

    public Kasaplar(){}

    public Kasaplar(String dukkanAd, String adres,String yetkiliAd,String yetkiliTel,BigDecimal kucukbasFiyat,BigDecimal buyukbasFiyat,Boolean aracHizmeti,BigDecimal aracUcret){
        this.adres = adres;
        this.aracHizmeti = aracHizmeti;
        this.aracUcret = aracUcret;
        this.dukkanAd = dukkanAd;
        this.kucukbasFiyat = kucukbasFiyat;
        this.yetkiliAd = yetkiliAd;
        this.yetkiliTel = yetkiliTel;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getadres(){return adres;}
    public void setadres(String adres){this.adres = adres;}

    public Boolean getaracHizmeti(){return aracHizmeti;}
    public void setaracHizmeti(Boolean aracHizmeti){this.aracHizmeti = aracHizmeti;}

    public BigDecimal getaracUcret(){return aracUcret;}
    public void setaracUcret(BigDecimal aracUcret){this.aracUcret = aracUcret;}
    
    public String getdukkanAd(){return dukkanAd;}
    public void setdukkanAd(String dukkanAd){this.dukkanAd = dukkanAd;}

    public BigDecimal getkucukbasFiyat(){return kucukbasFiyat;}
    public void setkucukbasFiyat(BigDecimal kucukbasFiyat){this.kucukbasFiyat = kucukbasFiyat;}

    public String getyetkiliAd(){return yetkiliAd;}
    public void setyetkiliAd(String yetkiliAd){this.yetkiliAd = yetkiliAd;}

    public String getyetkiliTel(){return yetkiliTel;}
    public void setyetkiliTel(String yetkiliTel){this.yetkiliTel = yetkiliTel;}

    public List<KucukbasSaat> geKucukbasSaats(){return kucukbasSaats;}
    public void setKucukbasSaats(List<KucukbasSaat> kucukbasSaats){this.kucukbasSaats = kucukbasSaats;}

    public void addKucukbasSaat(KucukbasSaat saat){
        kucukbasSaats.add(saat);
        saat.setKasap(this);
    }
    public void removeKucukbasSaat(KucukbasSaat saat){
        kucukbasSaats.remove(saat);
        saat.setKasap(null);
    }
}


