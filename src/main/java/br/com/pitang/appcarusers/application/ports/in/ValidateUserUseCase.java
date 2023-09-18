package br.com.pitang.appcarusers.application.ports.in;

public interface ValidateUserUseCase {

	void existsByEmail(String email);
	void existsByLogin(String login);
}
