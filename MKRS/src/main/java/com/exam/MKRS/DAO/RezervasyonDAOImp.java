package com.exam.MKRS.DAO;

import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.exam.MKRS.Durum;
import com.exam.MKRS.entity.Kasaplar;
import com.exam.MKRS.entity.KucukbasSaat;
import com.exam.MKRS.entity.Rezervasyon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class RezervasyonDAOImp implements RezervasyonDAO {
    private EntityManager entityManager;
    public RezervasyonDAOImp(EntityManager theEntity){
        this.entityManager = theEntity;
    }
   @Override
   @Transactional
public void randevuEkle(Rezervasyon rezervasyon) {
    // Kasap bilgisi
    TypedQuery<Kasaplar> query = entityManager.createQuery(
        "SELECT k FROM Kasaplar k WHERE k.dukkanAd = :ad", Kasaplar.class
    );
    query.setParameter("ad", rezervasyon.getrAlinanDukkan());
    List<Kasaplar> kasapListe = query.getResultList();

    if (kasapListe.isEmpty()) {
        throw new IllegalArgumentException("Kasap bulunamadi: " + rezervasyon.getrAlinanDukkan());
    }

    Kasaplar kasap = kasapListe.get(0);
    Integer kasapId = kasap.getId();

    
    LocalTime start = rezervasyon.getrAlanRandevu();
    int rSuresi = 15;
    LocalTime end = start.plusMinutes(rSuresi);

    
    entityManager.persist(rezervasyon);

    
    TypedQuery<KucukbasSaat> query2 = entityManager.createQuery(
        "SELECT s FROM KucukbasSaat s WHERE s.kasap.id = :thekasapId AND s.saat >= :start AND s.saat < :end",
        KucukbasSaat.class
    );
    query2.setParameter("thekasapId", kasapId);
    query2.setParameter("start", start);
    query2.setParameter("end", end);

    List<KucukbasSaat> rSaat = query2.getResultList();
    for (KucukbasSaat c : rSaat) {
        c.setDurum(Durum.DOLU);
    }
}
    
    @Override
   @Transactional
public void randevuSil(Integer id) {
    Rezervasyon rezervasyon = entityManager.find(Rezervasyon.class, id);
    if (rezervasyon == null) {
        throw new IllegalArgumentException("Rezervasyon bulunamadi : " + id);
    }

    // Kasap bilgisi
    TypedQuery<Kasaplar> query = entityManager.createQuery(
        "SELECT k FROM Kasaplar k WHERE k.dukkanAd = :ad", Kasaplar.class
    );
    query.setParameter("ad", rezervasyon.getrAlinanDukkan());
    List<Kasaplar> kasapListe = query.getResultList();

    if (kasapListe.isEmpty()) {
        throw new IllegalArgumentException("Kasap bulunamadi: " + rezervasyon.getrAlinanDukkan());
    }

    Kasaplar kasap = kasapListe.get(0);
    Integer kasapId = kasap.getId();

    // Randevu saat aralığı
    LocalTime start = rezervasyon.getrAlanRandevu();
    int rSuresi = 15;
    LocalTime end = start.plusMinutes(rSuresi);

    // Rezervasyonu sil
    entityManager.remove(rezervasyon);

    // Küçükbaş saatleri BOŞ yap
    TypedQuery<KucukbasSaat> query2 = entityManager.createQuery(
        "SELECT s FROM KucukbasSaat s WHERE s.kasap.id = :thekasapId AND s.saat >= :start AND s.saat < :end",
        KucukbasSaat.class
    );
    query2.setParameter("thekasapId", kasapId);
    query2.setParameter("start", start);
    query2.setParameter("end", end);

    List<KucukbasSaat> rSaat = query2.getResultList();
    if (!rSaat.isEmpty()) {
        for (KucukbasSaat c : rSaat) {
            c.setDurum(Durum.BOŞTA);
        }
    } else {
        System.out.println("Uyarı: Silinecek rezervasyon için saat bulunamadı.");
    }
}

    @Override
    public List<Rezervasyon> randevuSirala(){
        TypedQuery<Rezervasyon> query = entityManager.createQuery("FROM Rezervasyon",Rezervasyon.class);
        return query.getResultList();
    }
}



/* 
@Repository
public class RezervasyonDAOImp implements RezervasyonDAO {
    private EntityManager entityManager;
    public RezervasyonDAOImp(EntityManager theEntity){
        this.entityManager = theEntity;
    }
   @Override
@Transactional
public void randevuEkle(Rezervasyon rezervasyon) {
    // Kasap bilgisi
    TypedQuery<Kasaplar> query = entityManager.createQuery(
        "SELECT k FROM Kasaplar k WHERE k.dukkanAd = :ad", Kasaplar.class
    );
    query.setParameter("ad", rezervasyon.getrAlinanDukkan());
    List<Kasaplar> kasapListe = query.getResultList();

    if (kasapListe.isEmpty()) {
        throw new IllegalArgumentException("Kasap bulunamadi: " + rezervasyon.getrAlinanDukkan());
    }

    Kasaplar kasap = kasapListe.get(0);
    Integer kasapId = kasap.getId();

    // Randevu süresi
    LocalTime start = rezervasyon.getrAlanRandevu();
    int rSuresi = 15;
    LocalTime end = start.plusMinutes(rSuresi);

    // Rezervasyonu kaydet
    entityManager.persist(rezervasyon);

    // Küçükbaş saatleri güncelle
    TypedQuery<KucukbasSaat> query2 = entityManager.createQuery(
        "SELECT s FROM KucukbasSaat s WHERE s.kasap.id = :thekasapId AND s.saat >= :start AND s.saat < :end",
        KucukbasSaat.class
    );
    query2.setParameter("thekasapId", kasapId);
    query2.setParameter("start", start);
    query2.setParameter("end", end);

    List<KucukbasSaat> rSaat = query2.getResultList();
    for (KucukbasSaat c : rSaat) {
        c.setDurum(Durum.DOLU);
    }
}
    
    @Override
    @Transactional
    public void randevuSil(Integer id){
       Rezervasyon rezervasyon = entityManager.find(Rezervasyon.class, id);
       if(rezervasyon == null){throw new IllegalArgumentException("Rezervasyon bulunamadi : " + id);}
       String dukkanAd2 = rezervasyon.getrAlanIsim();
       TypedQuery<Kasaplar> query = entityManager.createQuery("SELECT k FROM Kasaplar k WHERE k.dukkanAd = :ad",Kasaplar.class);
       query.setParameter("ad", dukkanAd2);
       List<Kasaplar> kasapListe = query.getResultList();

       Kasaplar kasap = kasapListe.get(0);
       Integer kasapId = kasap.getId();
       
       LocalTime start = rezervasyon.getrAlanRandevu();
       int rSuresi = 15;
       LocalTime end = start.plusMinutes(rSuresi);



       entityManager.remove(rezervasyon);


       TypedQuery<KucukbasSaat> query2 = entityManager.createQuery("SELECT s FROM KucukbasSaat s "+"WHERE s.kasap.id =:thekasapId AND s.saat >= :start AND s.saat< :end",KucukbasSaat.class);

       query2.setParameter("thekasapId", kasapId);
       query2.setParameter("start", start);
       query2.setParameter("end", end);

       List<KucukbasSaat> rSaat = query2.getResultList();
       for(KucukbasSaat c : rSaat){
        c.setDurum(Durum.BOŞTA);
       }
    }

    @Override
    public List<Rezervasyon> randevuSirala(){
        TypedQuery<Rezervasyon> query = entityManager.createQuery("FROM Rezervasyon",Rezervasyon.class);
        return query.getResultList();
    }
}
    

*/