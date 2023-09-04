package com.example.drone.service;

import com.example.drone.model.Load;

import java.util.List;

public interface LoadService {

    void save(Load load);

    List<Load> getAll();
}
