package com.naha.crimereportingsystem.police;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliceServiceImpl implements PoliceService {

    @Autowired
    PoliceRepository policeRepository;

    @Override
    public List<Police> findAllPoliceDetails() {
        List<Police> police = new ArrayList<>();
        policeRepository.findAll().forEach(police::add);
        return police;
    }

    @Override
    public Police findSinglePoliceDetail(Long id) {
        return policeRepository.findById(id).orElse(null);
    }

    @Override
    public Police savePoliceDetail(Police police) {
        return policeRepository.save(police);
    }

    @Override
    public Police editPoliceDetails(String name, long id) {
        Police toBeEditedPolice = findSinglePoliceDetail(id);
        toBeEditedPolice.setName(name);
        return savePoliceDetail(toBeEditedPolice);
    }

    // Not Used
    @Override
    public void deletePoliceDetail(long id) {
        policeRepository.deleteById(id);
    }
}