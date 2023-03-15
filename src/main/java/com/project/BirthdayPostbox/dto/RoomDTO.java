package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.entity.RoomEntity;
import java.sql.Date;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomId;
    private String roomName;
    private Date roomBirthdate;
    private String roomEmail;
    private String ownerCode;

    public static RoomDTO toRoomDTO(RoomEntity roomEntity) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomId(roomEntity.getId());
        roomDTO.setRoomBirthdate(roomEntity.getRoomBirthdate());
        roomDTO.setRoomName(roomEntity.getRoomName());
        roomDTO.setRoomEmail(roomEntity.getRoomEmail());
        roomDTO.setOwnerCode(roomEntity.getOwnerCode());

        return roomDTO;
    }
}
