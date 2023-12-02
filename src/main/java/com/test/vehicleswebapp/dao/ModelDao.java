package com.test.vehicleswebapp.dao;

import com.test.vehicleswebapp.model.Model;
import com.test.vehicleswebapp.model.Vehicle;

import java.util.List;

public interface ModelDao {
    public List<Model> findAllModels();
}
