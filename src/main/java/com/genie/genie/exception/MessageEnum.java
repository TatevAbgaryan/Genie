package com.genie.genie.exception;

public enum MessageEnum {

	NOT_SUPPORTED_REQUEST(1, Type.ERROR, "not.supported.request"),
	AUTHENTICATION_FAILED(2, Type.ERROR, "authentication.failed"),
	ERROR_OCCURRED(3, Type.ERROR, "error.occurred"),
	ERROR(4, Type.ERROR, "error"),
	NOT_FOUND(6, Type.ERROR, "not.found"),
	INVALID_JSON_VALUES(7, Type.ERROR, "invalid.json.values"),
	PERMISSION_DENIED(8, Type.ERROR, "permission.denied"),
	METHOD_ARGUMENT_NOT_VALID(9, Type.ERROR, "method.argument.not.valid"),
	PERMISSION_DENIED_FOR_DD_VIEW(10, Type.ERROR, "permission.denied.for.dd.view"),
	ERROR_GETTING_FILE_PROPERTIES(11, Type.ERROR, "error.getting.file.properties"),
	GENERAL_EXCEPTION(12, Type.ERROR, "general.exception"),
	DATA_INTEGRITY_VIOLATION(13, Type.ERROR, "data.integrity.violation"),
	INVALID_DESCRPTION_SIZE(16, Type.ERROR, "invalid.description.size"),
	DATABASE_CONNECTION_LOST(19, Type.ERROR, "database.connection.lost" ),
	FAILED_LOAD_CLASS(20, Type.ERROR, "failed.load.class" ),
	TIME_PROVIIDER_INSTANTIATION_EXCEPTION(21, Type.ERROR, "failed.instantiate.time.provider" ),
	INSITE_CONNECTION_FAILED(22, Type.ERROR, "insite.connection.failed"),
	JSON_CAST_FAILED(23, Type.ERROR, "json.cast.failed"),
	PERMITTED_TABLES_LIST_IS_EMPTY(24, Type.WARNING, "permitted.tables.list.is.empty"),
	PREFERENCES_UPDATED_SUCCESS(5, Type.INFO, "preferences.update.success"),
	PREFERENCES_INVALID_JDBCTIMEOUT(14, Type.ERROR, "preferences.invalid.jdbctimeout"),
	INVALID_NAME(15, Type.ERROR, "name.invalid"),


	SESSION_EXPIRED(16, Type.ERROR, "session.expired"),
	LOGIN_FAILED(17, Type.ERROR, "wrong.username.password"),
	USER_EMAIL_EXISTS(18, Type.ERROR, "username.email.exists"),
	USER_EMPTY_EMAIL(19, Type.ERROR, "user.empty.email");	
	
	private final Type type;
	private final int code;
	private final String messageProperty;
	
	private MessageEnum(int code, Type type, String messageProperty) {
		this.code = code;
		this.type = type;
		this.messageProperty = messageProperty;
	}

	public int code() {
		return code;
	}
	
	public Type type() {
		return type;
	}
	
	public String messageProperty() {
       		return messageProperty;
	}
	
	public enum Type {
		INFO, ERROR, WARNING
	}


}
