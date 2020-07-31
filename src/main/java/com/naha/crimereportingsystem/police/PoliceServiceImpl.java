package com.naha.crimereportingsystem.police;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliceServiceImpl implements PoliceService {

    @Autowired
    PoliceRepository policeRepository;

    public List<Police> findAllPoliceDetails() {
        List<Police> police = new ArrayList<>();
        policeRepository.findAll().forEach(police::add);
        return police;
    }

    public Police findSinglePoliceDetail(Long id) {
        return policeRepository.findById(id).orElse(null);
    }

    public Police savePoliceDetail(Police police) {
        return policeRepository.save(police);
    }

    public void deletePoliceDetail(Long id) {
        policeRepository.deleteById(id);
    }
}