package com.genie.genie.dto;

public class SessionDto extends BaseDto{

    private UserDto user;
    private String authToken;


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
