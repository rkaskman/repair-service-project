package com.ttu.roman.repository.jpa;

import com.ttu.roman.model.Bike;
import com.ttu.roman.repository.BikeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaBikeRepositoryImpl implements BikeRepository {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Bike> getAllBikes() {
        return em.createQuery("from Bike").getResultList();
    }

    @Override
    public Bike getBikeById(int id) {
        return em.find(Bike.class, id);
    }

    @Override
    public void saveBike(Bike bike) {
        em.merge(bike);
    }
}
