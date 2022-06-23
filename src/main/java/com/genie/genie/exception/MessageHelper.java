package com.genie.genie.exception;

import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.genie.genie.dto.MessageDto;

@Component("messageHelper")
public class MessageHelper {

	@Resource
	private MessageSource messageSource;

	public MessageDto createMessageDto(boolean success, MessageEnum messageEnum, Object... args) {
		MessageDto messageDto = new MessageDto(success, getMessage(messageEnum, args));
		messageDto.setCode(messageEnum.code());
		messageDto.setType(messageEnum.type());

		return messageDto;
	}

	public MessageDto createMessageDto(AppException ex) {
		MessageEnum messageEnum = ex.getMessageEnum();
		Object[] args = ex.getArgs();
		return createMessageDto(false, messageEnum, args);
	}

	public MessageDto createMessageDto(AppException ex, Properties properties) {
		MessageEnum messageEnum = ex.getMessageEnum();
		Object[] args = ex.getArgs();
		MessageDto messageDto = createMessageDto(false, messageEnum, args);
		messageDto.setProperties(properties);
		return messageDto;
	}

	public String getMessage(MessageEnum messageEnum, Object... args) {
		return messageSource.getMessage(messageEnum.messageProperty(), args, Locale.getDefault());
	}

}
