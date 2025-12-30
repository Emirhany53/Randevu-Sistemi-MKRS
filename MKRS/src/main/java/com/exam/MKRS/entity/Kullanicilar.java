package com.exam.MKRS.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "kullanici_tablo")
public class Kullanicilar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kullanici_id")
    private int kl_id;

    @Column(name = "kullanici_isim")
    private String isim;

    @Column(name = "kullanici_soyisim")
    private String soyisim;

    @Column(name = "kullanici_telno",unique = true)
    private String kl_telno;

    public Kullanicilar(){}
    public Kullanicilar(String isim,String soyisim,String kl_telno){
        this.kl_telno = kl_telno;
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public int getklId(){return kl_id;}
    public void setklId(int kl_id){this.kl_id = kl_id;}

    public String getisim(){return isim;}
    public void setisim(String isim){this.isim = isim;}

    public String getsoyisim(){return soyisim;}
    public void setsoyisim(String soyisim){this.soyisim=soyisim;}

    public String getKl_telno(){return kl_telno;}
    public void setKl_telno(String kl_telno){this.kl_telno = kl_telno;}


}
