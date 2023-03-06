package com.project.BirthdayPostbox.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private String roomId;
    private String roomName;
    private Date roomBirthdate;
    private String roomEmail;
    private String ownerCode;
}
