package com.example.demo.Controller.serviceImpl;

import com.example.demo.entities.School;
import com.example.demo.repositories.SchoolRepository;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Override
    public School create(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School update(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public Long deleteById(Long id) {
        if (schoolRepository.existsById(id)){
            schoolRepository.deleteById(id);
            return id;
        }
        return null;
    }
}
