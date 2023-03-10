package com.project.BirthdayPostbox.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomId;
    private String roomName;
    private Date roomBirthdate; //Date로 하면 오류 있어서 일단 String으로
    private String roomEmail;
    private String ownerCode;
}
