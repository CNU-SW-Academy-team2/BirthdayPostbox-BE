package com.project.BirthdayPostbox.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Room {
    @Id
    private String roomId;
    private Date roomBirthdate;
    private String roomEmail;
    private String ownerCode;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public Date getRoomBirthdate() {
        return roomBirthdate;
    }

    public void setRoomBirthdate(Date roomBirthdate) {
        this.roomBirthdate = roomBirthdate;
    }
    public String getRoomEmail() {
        return roomEmail;
    }

    public void setRoomEmail(String roomEmail) {
        this.roomEmail = roomEmail;
    }
    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }
}
