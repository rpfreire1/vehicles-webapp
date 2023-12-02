package com.test.vehicleswebapp.dao.impl;
import com.test.vehicleswebapp.dao.ModelDao;
import com.test.vehicleswebapp.model.Model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
public class ModelDaoImpl implements ModelDao {
    @PersistenceContext(unitName="VehiclePU")
    EntityManager em;

    @Override
    public List<Model> findAllModels() {
        return em.createNamedQuery("Model.findAll").getResultList();
    }
}
