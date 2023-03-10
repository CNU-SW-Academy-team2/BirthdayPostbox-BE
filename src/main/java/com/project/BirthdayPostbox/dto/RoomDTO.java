package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.entity.RoomEntity;
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

    public static RoomDTO toRoomDTO(RoomEntity roomEntity) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomId(roomEntity.getRoomId());
        roomDTO.setRoomBirthdate(roomEntity.getRoomBirthdate());
        roomDTO.setRoomName(roomEntity.getRoomName());
        roomDTO.setRoomEmail(roomEntity.getRoomEmail());
        roomDTO.setOwnerCode(roomEntity.getOwnerCode());

        return roomDTO;
    }
}
