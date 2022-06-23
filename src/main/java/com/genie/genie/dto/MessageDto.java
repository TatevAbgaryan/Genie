package com.genie.genie.dto;

import java.util.Properties;

import com.genie.genie.exception.MessageEnum;
import com.genie.genie.exception.MessageEnum.Type;;

public class MessageDto extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	
	private String message;
	
	private Integer code;
	
	private MessageEnum.Type type;
	
	private Properties properties;
	
	private Object object;
	
	public MessageDto() {
	}
	
	public MessageDto(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public MessageDto(boolean success, String message, Type type) {
		this(success, message);
		this.type = type;
	}
	
	public MessageDto(boolean success, String message, Type type, Properties properties) {
		this(success, message);
		this.type = type;
		this.properties = properties;
	}

	public MessageDto(boolean success, String message, Integer code, Type type) {
		this(success, message, type);
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public MessageEnum.Type getType() {
		return type;
	}

	public void setType(MessageEnum.Type type) {
		this.type = type;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void addProperty(String key, Object value) {
		if (properties == null) {
			this.properties = new Properties();
		}
		this.properties.put(key, value);
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
