package br.com.pitang.appcarusers.application.ports.in;

public interface ValidateCarUseCase {

	void existsByLicensePlate(String licensePlate);
}
