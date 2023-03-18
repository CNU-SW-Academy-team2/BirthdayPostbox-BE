package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.entity.RoomEntity;
import java.sql.Date;
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
    private String roomEmail;
    private String ownerCode;
}
