package com.eps.Appointments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eps.Appointments.DTOs.HeadquarterDTO;
import com.eps.Appointments.mappers.HeadquarterMapper;
import com.eps.Appointments.persistance.entities.Headquarter;
import com.eps.Appointments.persistance.repositories.HeadquarterRepository;

@Service
public class HeadquarterService {

    @Autowired
    private HeadquarterRepository headquarterRepository;
    @Autowired
    private HeadquarterMapper headquarterMapper;

    public HeadquarterDTO getByName(String name){
        return headquarterMapper.toHeadquarterDTO(headquarterRepository.findByName(name).map(h -> {
            return h;
        }).orElse(null));
    }

    public List<HeadquarterDTO> getAll(){
        return headquarterMapper.toHeadquarterDTOs((List<Headquarter>) headquarterRepository.findAll());
    }

}
