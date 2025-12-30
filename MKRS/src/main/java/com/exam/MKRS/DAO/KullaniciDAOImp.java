package com.exam.MKRS.DAO;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.exam.MKRS.entity.Kullanicilar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class KullaniciDAOImp implements KullaniciDAO {

    private EntityManager entityManager;

    public KullaniciDAOImp(EntityManager thEntityManager){
        this.entityManager = thEntityManager;
    }
    @Override
    @Transactional
    public void k_kaydet(Kullanicilar kullanici){
        entityManager.persist(kullanici);
    }
    @Override
    public List<Kullanicilar> k_idyeGoreGetir(Integer di){
        TypedQuery<Kullanicilar> query = entityManager.createQuery("FROM Kullanicilar WHERE id =: theData", Kullanicilar.class);
        query.setParameter("theData", di);
        return query.getResultList();
    }
    @Override
    public List<Kullanicilar> k_hepsiniGetir(){
        TypedQuery<Kullanicilar> query = entityManager.createQuery("FROM Kullanicilar",Kullanicilar.class);
        return query.getResultList();
    }
    @Override
    public void k_guncelle(Kullanicilar kullanici){
        entityManager.merge(kullanici);
    }
    @Override
    public void k_sil(Integer id){
        Kullanicilar kullanici = entityManager.find(Kullanicilar.class, id);
        entityManager.remove(kullanici);
    }
    @Override
    public int k_hepsiniSil(){
        int rows = entityManager.createQuery("DELETE FROM Kullanicilar").executeUpdate();
        return rows;
    } 
    
}
