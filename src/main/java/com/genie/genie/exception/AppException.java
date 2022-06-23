package com.genie.genie.exception;

import java.util.Arrays;


@SuppressWarnings("serial")
public class AppException extends RuntimeException {

    private MessageEnum messageEnum;
    private Object[] args;

    public AppException(MessageEnum messageEnum, Object... args) {
        this.messageEnum = messageEnum;
        this.args = args;
    }

    public MessageEnum getMessageEnum() {
        return messageEnum;
    }

    public void setMessageEnum(MessageEnum messageEnum) {
        this.messageEnum = messageEnum;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "AppException [messageEnum=" + messageEnum + ", args=" + Arrays.toString(args) + "]";
    }

}

