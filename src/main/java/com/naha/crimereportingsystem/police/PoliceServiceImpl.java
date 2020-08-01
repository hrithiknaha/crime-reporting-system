package com.naha.crimereportingsystem.police;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliceServiceImpl implements PoliceService {

    @Autowired
    PoliceDAOImpl policeDAO;

    @Override
    public List<Police> findAllPoliceDetails() {
        List<Police> police = new ArrayList<>();
        policeDAO.findAll().forEach(police::add);
        return police;
    }

    @Override
    public Police findSinglePoliceDetail(Long id) {
        return policeDAO.findById(id);
    }

    @Override
    public Police savePoliceDetail(Police police) {
        return policeDAO.save(police);
    }

    @Override
    public Police editPoliceDetails(String name, long id) {
        Police toBeEditedPolice = findSinglePoliceDetail(id);
        toBeEditedPolice.setName(name);
        return policeDAO.save(toBeEditedPolice);
    }

    // Not Used
    @Override
    public void deletePoliceDetail(long id) {
        policeDAO.deleteById(id);
    }
}