/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.parking_control_curso.services;

import com.api.parking_control_curso.models.ParkingSpotModel;
import com.api.parking_control_curso.repositores.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author luciano
 */
//O bean é a ponte entre controler e o repository
@Service
public class ParkingSpotService {
    
    final ParkingSpotRepository parkingSpotRepository;    //Cria um ponto de injeção, determinato momento vai ter que injetar dependencias do repository
    
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
    
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
        return parkingSpotRepository.save(parkingSpotModel); // Salva os dados dos usuarios
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment,block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
