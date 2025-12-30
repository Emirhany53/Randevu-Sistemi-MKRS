package com.exam.MKRS.DAO;
import java.time.LocalTime;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.exam.MKRS.Durum;
import com.exam.MKRS.entity.Kasaplar;
import com.exam.MKRS.entity.KucukbasSaat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Primary
public class KucukbasSaatDAOImp implements KucukbasSaatDAO {
    private EntityManager entityManager;


    public KucukbasSaatDAOImp(EntityManager thentityManager){
        this.entityManager = thentityManager;
    }

    
    @Override
    public List<KucukbasSaat> tumSaatleriGetir(){
        TypedQuery<KucukbasSaat> query = entityManager.createQuery("FROM KucukbasSaat",KucukbasSaat.class);
        return query.getResultList();
    }
    @Override
    public void SaatOlustur(){
        List<Kasaplar> kasaplar = entityManager.createQuery("FROM Kasaplar",Kasaplar.class).getResultList();

        if(kasaplar.isEmpty()){throw new RuntimeException("Eklenecek kasap bulunamadi");}

        LocalTime basla = LocalTime.of(6,0);
        LocalTime bitir = LocalTime.of(21, 0);

        for(Kasaplar k : kasaplar){
            LocalTime add = basla; 

            while(add.isBefore(bitir) || add.equals(bitir)){
            TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(s) FROM KucukbasSaat s WHERE s.kasap =:kasap AND s.saat =:saat",Long.class);
            query.setParameter("kasap", k);
            query.setParameter("saat", add);
            Long count = query.getSingleResult();

            if(count == 0){
            KucukbasSaat s = new KucukbasSaat();
            s.setSaat(add);
            s.setDurum(Durum.BOŞTA);
            s.setKasap(k);
            entityManager.persist(s);
            add = add.plusMinutes(15);
            }
           }
        }
        
    }
    @Override
    public List<KucukbasSaat> saateGoreGetir(LocalTime st){
        TypedQuery<KucukbasSaat> query = entityManager.createQuery("FROM KucukbasSaat WHERE saat =: thedata",KucukbasSaat.class);

        query.setParameter("thedata", st);
        return query.getResultList();

    }
    @Override
    public List<KucukbasSaat> bostaGetir(Durum durum){
        TypedQuery<KucukbasSaat> query = entityManager.createQuery("FROM KucukbasSaat WHERE durum =: BOSTA",KucukbasSaat.class);
        return query.getResultList();
    }

    
}
