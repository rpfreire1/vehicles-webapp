package com.test.vehicleswebapp.dao.impl;

import com.test.vehicleswebapp.dao.ModelDao;
import com.test.vehicleswebapp.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ModelDaoImpl implements ModelDao {
    @PersistenceContext(unitName = "VehiclePU")
    EntityManager em;

    @Override
    public List<Model> findAllModels() {
        return em.createNamedQuery("Model.findAll").getResultList();
    }
}
