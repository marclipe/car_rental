package br.com.marclipe.car_rental.modules.car.controllers;

import br.com.marclipe.car_rental.modules.car.CarEntity;
import br.com.marclipe.car_rental.modules.car.CarRepository;
import br.com.marclipe.car_rental.modules.car.useCases.CreateCarUseCase;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/car")
public class CarControllers {
  @Autowired
  private CreateCarUseCase createCarUseCase; 

  @Autowired
  private CarRepository carRepository; 

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CarEntity carEntity) {
    try {
      var result = this.createCarUseCase.execute(carEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/all")
  public Iterable<CarEntity> getAllCars() {
    return carRepository.findAll();
  }
}
