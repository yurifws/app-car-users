package br.com.pitang.appcarusers.application.ports.out;

public interface ValidateCarPort {

	boolean existsByLicensePlate(String licensePlate);
}
