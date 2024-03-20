package br.com.marclipe.car_rental.modules.car.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marclipe.car_rental.modules.car.CarEntity;
import br.com.marclipe.car_rental.modules.car.CarRepository;
import br.com.marclipe.car_rental.modules.car.exceptions.CarFoundException;

@Service
public class CreateCarUseCase {

  @Autowired
  private CarRepository carRepository; 
  
  public CarEntity execute(CarEntity carEntity) {
    this.carRepository.findByNameOrLicensePlate(carEntity.getName(), carEntity.getLicensePlate())
    .ifPresent(car -> {
      throw new CarFoundException();
    });
    
    return this.carRepository.save(carEntity);
  }

}
