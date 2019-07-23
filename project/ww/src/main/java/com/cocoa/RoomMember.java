package com.cocoa;

public class RoomMember {

private  String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public RoomMember(String userName) {
        UserName = userName;
    }
}
