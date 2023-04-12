package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.entity.RoomEntity;
import java.sql.Date;

import com.project.BirthdayPostbox.util.RoomCategory;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomId;
    private String roomName;
    private Date roomBirthdate;
    private RoomCategory roomCategory;
    private String roomEmail;
    private String ownerCode;
}
