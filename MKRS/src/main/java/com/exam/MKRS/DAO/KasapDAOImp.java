package com.exam.MKRS.DAO;

//import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.MKRS.entity.Kasaplar;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class KasapDAOImp implements KasapDAO {
    private EntityManager entityManager;

    @Autowired
    public KasapDAOImp(EntityManager theEntity){
        this.entityManager = theEntity;
    }

    @Override
    @Transactional
    public void kaydet(Kasaplar kasap){
        entityManager.persist(kasap);
    }

    @Override
    public List<Kasaplar> hepsiniGetir(){
        TypedQuery<Kasaplar> query = entityManager.createQuery("FROM Kasaplar",Kasaplar.class);

        return query.getResultList();
    }
    @Override
    public List<Kasaplar> yetkiliyeGoreAra(String ytAd){
        TypedQuery<Kasaplar> query = entityManager.createQuery("FROM Kasaplar WHERE yetkiliAd=:theData",Kasaplar.class);

        query.setParameter("theData", ytAd);
        return query.getResultList();
    }
    @Override
    public List<Kasaplar> teleGoreAra(String ytTel){
        TypedQuery<Kasaplar> query = entityManager.createQuery("FROM Kasaplar WHERE yetkiliTel=:theDat",Kasaplar.class);

        query.setParameter("theDat", ytTel);
        return query.getResultList();
    }
    @Override
    public List<Kasaplar> aracHizmeteGoreAra(Boolean aracH){
        TypedQuery<Kasaplar> query = entityManager.createQuery("FROM Kasaplar WHERE aracHizmeti=:theData" , Kasaplar.class);
        query.setParameter("theData", aracH);
        return query.getResultList();
    }
    @Override
    public void guncelle(Kasaplar kasap){
        entityManager.merge(kasap);
    }
    @Override
    public void sil(Integer id){
        Kasaplar kasap = entityManager.find(Kasaplar.class, id);
        entityManager.remove(kasap);
    } 
    @Override
    public int hepsiniSil(){
        int rows = entityManager.createQuery("DELETE FROM Kasaplar").executeUpdate();
        return rows;
    }
    @Override
    public Kasaplar idyeGoreGetir(Integer d){
        Kasaplar kasap = entityManager.find(Kasaplar.class, d);
        return kasap;
    }
   
    
    


    
}
