package br.com.pitang.appcarusers.adapters.web.in.exceptionhandler.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Builder
public class ErrorDto {
	
	private String message;
	private Integer code;
	private List<Object> objects;
	
	@Getter
	@Builder
	public static class Object{

		private String name;
		private String message;
	}
}
