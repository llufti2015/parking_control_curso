/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.parking_control_curso.repositores;

import com.api.parking_control_curso.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 *
 * @author luciano
 */
//Adiciona neste repositore a classe model e o identificador que no caso é um ID
//Métodos prontos para transações com o banco de dados exemplo Insert Delete Update
@Repository
public interface ParkingSpotRepository  extends JpaRepository<ParkingSpotModel, UUID>{
    boolean existsByLicensePlateCar(String licensePlateCar);
     boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}
