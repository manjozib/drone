package com.example.drone.service;

import com.example.drone.model.Load;
import com.example.drone.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService{

    private final LoadRepository loadRepository;

    public LoadServiceImpl(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Override
    public void save(Load load) {
        loadRepository.save(load);
    }

    @Override
    public List<Load> getAll() {
        return loadRepository.findAll();
    }
}
