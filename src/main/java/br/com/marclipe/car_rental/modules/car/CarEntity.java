package br.com.marclipe.car_rental.modules.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "car")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O campo é obrigatório!")
  private String name;

  @Length(min = 7, max = 7, message = "É obrigatório a placa ter 7 caracteres")
  @Pattern(regexp = "\\S+", message = "O campo {0} não deve conter espaços")
  private String licensePlate;
  private String brand;

  private String color;

  private String vehicleRegistration;
  
  @CreationTimestamp
  private LocalDateTime createdAt;
}
