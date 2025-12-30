package com.exam.MKRS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.time.LocalTime;


@Entity
@Table(name ="rezervasyon_tablo")
public class Rezervasyon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private int r_id;

    @Column(name = "r_alan_isim")
    private String rAlanIsim;

    @Column(name = "r_alan_soyisim")
    private String rAlanSoyisim;

    @Column(name = "r_alan_telNo")
    private String rAlanTelno;

    @Column(name = "r_alinan_dukkan")
    private String rAlinanDukkan;

    @Column(name = "r_alan_randevu_saati")
    private LocalTime rAlanRandevu;

    public Rezervasyon(){}

    public Rezervasyon(String rAlanIsim,String rAlanSoyisim,String rAlanTelno,String rAlinanDukkan,LocalTime rAlanRandevu){
        this.rAlanIsim = rAlanIsim;
        this.rAlanRandevu = rAlanRandevu;
        this.rAlanSoyisim = rAlanSoyisim;
        this.rAlanTelno = rAlanTelno;
        this.rAlinanDukkan = rAlinanDukkan;
    }

    public int getrId(){return r_id;}
    public void setrId(int r_id){this.r_id=r_id;}

    public String getrAlanIsim(){return rAlanIsim;}
    public void setrAlanIsim(String rAlanIsim){this.rAlanIsim=rAlanIsim;}

    public String getrAlanSoyisim(){return rAlanSoyisim;}
    public void setrAlanSoyisim(String rAlanSoyisim){this.rAlanSoyisim=rAlanSoyisim;}

    public String getrAlinanDukkan(){return rAlinanDukkan;}
    public void setrAlinanDukkan(String rAlinanDukkan){this.rAlinanDukkan=rAlinanDukkan;}

    public LocalTime getrAlanRandevu(){return rAlanRandevu;}
    public void setrAlanRandevu(LocalTime rAlanRandevu){this.rAlanRandevu = rAlanRandevu;}

}
