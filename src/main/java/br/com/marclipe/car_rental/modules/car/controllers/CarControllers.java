package br.com.marclipe.car_rental.modules.car.controllers;

import br.com.marclipe.car_rental.modules.car.CarEntity;
import br.com.marclipe.car_rental.modules.car.CarRepository;
import br.com.marclipe.car_rental.modules.car.exceptions.CarFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/car")
public class CarControllers {
  @Autowired
  private CarRepository carRepository;

  @PostMapping("/")
  public CarEntity create(@Valid @RequestBody CarEntity carEntity) {
    this.carRepository.findByNameOrLicensePlate(carEntity.getName(), carEntity.getLicensePlate())
    .ifPresent(car -> {
      throw new CarFoundException();
    });
    
    return this.carRepository.save(carEntity);
  }

  @GetMapping("/all")
  public Iterable<CarEntity> getAllCars() {
    return carRepository.findAll();
  }
}
