package br.com.marclipe.car_rental.modules.car.exceptions;

public class CarFoundException extends RuntimeException {
  public CarFoundException() {
    super("The car already exists!"); 
  }
}
