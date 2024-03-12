package br.com.marclipe.car_rental.modules.car;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, UUID> { 
  Optional<CarEntity> findByNameOrLicensePlate(String name, String licensePlate);
}