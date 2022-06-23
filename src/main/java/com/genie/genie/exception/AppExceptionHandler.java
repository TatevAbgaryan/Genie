package com.genie.genie.exception;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.genie.genie.dto.MessageDto;

@RestControllerAdvice
public class AppExceptionHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(AppExceptionHandler.class);

	@Resource
	MessageHelper saMessageHelper;

	@ExceptionHandler(AppException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	public MessageDto appException(AppException appEx) {
		LOGGER.error(appEx.toString());
		MessageDto messageDto = saMessageHelper.createMessageDto(appEx);
		return messageDto;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MessageDto generalException(Exception ex) {
		LOGGER.error(ex.toString());
		MessageDto messageDto = saMessageHelper.createMessageDto(false, MessageEnum.GENERAL_EXCEPTION);
		return messageDto;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public MessageDto httpMessageNotReadableException(HttpMessageNotReadableException ex) {
		LOGGER.error(ex.getMessage());
		MessageDto messageDto = saMessageHelper.createMessageDto(false, MessageEnum.INVALID_JSON_VALUES);
		return messageDto;
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageDto methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		LOGGER.error(ex.getMessage());
		MessageDto messageDto = saMessageHelper.createMessageDto(false, MessageEnum.METHOD_ARGUMENT_NOT_VALID);
		return messageDto;
	}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public MessageDto methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		LOGGER.error(ex.getMessage());
		MessageDto messageDto = saMessageHelper.createMessageDto(false, MessageEnum.METHOD_ARGUMENT_NOT_VALID);
		return messageDto;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
	public MessageDto dataIntegrityViolationException(DataIntegrityViolationException ex) {
		LOGGER.error(ex.getMessage());
		MessageDto messageDto = saMessageHelper.createMessageDto(false, MessageEnum.DATA_INTEGRITY_VIOLATION);
		return messageDto;
	}
	
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class, HttpMediaTypeNotSupportedException.class, MissingServletRequestParameterException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public MessageDto httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		LOGGER.error(ex.getMessage());
		MessageDto messageDto = saMessageHelper.createMessageDto(false, MessageEnum.NOT_SUPPORTED_REQUEST);
		return messageDto;
	}
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MessageDto cannotCreateTransactionException(CannotCreateTransactionException ex) {
		LOGGER.error(ex.getMessage());
		return saMessageHelper.createMessageDto(false, MessageEnum.DATABASE_CONNECTION_LOST);
	}

}
