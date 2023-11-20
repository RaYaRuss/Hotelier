package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.HotelChainDTO;
import com.example.hotelier.model.dto.HotelDTO;
import com.example.hotelier.model.entity.HotelEntity;
import com.example.hotelier.repository.HotelRepository;
import com.example.hotelier.service.HotelChainService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class HotelChainServiceImpl  implements HotelChainService{

    private final HotelRepository hotelRepository;

    public HotelChainServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelChainDTO> getAllHotelChains() {
        Map<String, HotelChainDTO> hotelChains = new TreeMap<>();

        for (HotelEntity hotel : hotelRepository.findAll() ) {
            if (!hotelChains.containsKey(hotel.getHotelChain().getName())) {
                hotelChains.put(hotel.getHotelChain().getName(),
                        new HotelChainDTO(hotel.getHotelChain().getName(),
                        new ArrayList<>()));
            }
            hotelChains.get(hotel.getHotelChain().getName()).hotels().add(
                    new HotelDTO(hotel.getId(), hotel.getName()));

        }
        return hotelChains.values().stream().toList();
    }
}
