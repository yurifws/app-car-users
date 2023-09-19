package br.com.pitang.appcarusers.adapters.web.in.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.pitang.appcarusers.adapters.web.in.exceptionhandler.dto.ErrorDto;
import br.com.pitang.appcarusers.adapters.web.in.exceptionhandler.dto.ErrorDto.ErrorDtoBuilder;
import br.com.pitang.appcarusers.common.exception.EmailAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LicensePlateAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LoginAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.UnauthorizedException;
import br.com.pitang.appcarusers.common.exception.UnauthorizedInvalidSessionException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleValidacaoInternal(ex, ex.getBindingResult(), status, request);
	}

	private ResponseEntity<Object> handleValidacaoInternal(Exception ex, BindingResult bindingResult, HttpStatus status,
			WebRequest request) {
		List<ErrorDto.Object> errorObjects = bindingResult.getAllErrors().stream()
				.map(objectError -> {
					String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
					
					String name = objectError.getObjectName();
					if(objectError instanceof FieldError) {
						name = ((FieldError) objectError).getField();
					}
					return ErrorDto.Object.builder()
						.name(name)
						.message(message)
						.build();
				})
				.collect(Collectors.toList());
		
		ErrorDto errorDto = createErrorBuilder(status, "Missing fields")
				.objects(errorObjects)
				.build();
		return handleExceptionInternal(ex, errorDto, new HttpHeaders(), status, request);
	}
	
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handleExceptionInternal(ex, createErrorBuilder(status, ex.getMessage()).build(), new HttpHeaders(), status, request);

	}
	
	@ExceptionHandler(LicensePlateAlreadyExistsException.class)
	public ResponseEntity<Object> handleLicensePlateAlreadyExistsException(LicensePlateAlreadyExistsException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handleExceptionInternal(ex, createErrorBuilder(status, ex.getMessage()).build(), new HttpHeaders(), status, request);

	}
	
	@ExceptionHandler(LoginAlreadyExistsException.class)
	public ResponseEntity<Object> handleLoginAlreadyExistsException(LoginAlreadyExistsException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handleExceptionInternal(ex, createErrorBuilder(status, ex.getMessage()).build(), new HttpHeaders(), status, request);

	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return handleExceptionInternal(ex, createErrorBuilder(status, ex.getMessage()).build(), new HttpHeaders(), status, request);

	}
	
	@ExceptionHandler(UnauthorizedInvalidSessionException.class)
	public ResponseEntity<Object> handleUnauthorizedInvalidSessionException(UnauthorizedInvalidSessionException ex, WebRequest request) {
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return handleExceptionInternal(ex, createErrorBuilder(status, ex.getMessage()).build(), new HttpHeaders(), status, request);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleUncaught(Exception ex,
			WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return handleExceptionInternal(ex, createErrorBuilder(status, ex.getMessage()).build(), new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	private ErrorDtoBuilder createErrorBuilder(HttpStatus status, String message) {
		return ErrorDto.builder()
				.code(status.value())
				.message(message);
	}
	
}
