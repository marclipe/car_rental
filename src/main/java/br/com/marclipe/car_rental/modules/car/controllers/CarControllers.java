package br.com.marclipe.car_rental.modules.car.controllers;

import br.com.marclipe.car_rental.modules.car.CarEntity;
import br.com.marclipe.car_rental.modules.car.CarRepository;
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
    return this.carRepository.save(carEntity);
  }

  @GetMapping("/all")
  public Iterable<CarEntity> getAllCars() {
    return carRepository.findAll();
  }
}
