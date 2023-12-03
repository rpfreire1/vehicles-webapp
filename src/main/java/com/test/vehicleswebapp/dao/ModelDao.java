package com.test.vehicleswebapp.dao;

import com.test.vehicleswebapp.model.Model;

import java.util.List;

public interface ModelDao {
    List<Model> findAllModels();
}
