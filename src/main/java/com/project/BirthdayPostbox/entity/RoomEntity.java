package com.project.BirthdayPostbox.entity;


import com.project.BirthdayPostbox.dto.RoomDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Entity
@Getter
@Setter
@Table(name ="room_table")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 6, nullable = false)
    private String roomId;
    @Column(length = 60, nullable = false)
    private String roomName;
    @Column(nullable = false)
    private String roomBirthdate; //Date로 하면 오류 있어서 일단 String으로
    @Column(length = 50, nullable = false)
    private String roomEmail;
    @Column(length = 6)
    private String ownerCode;

    public static RoomEntity toSaveEntity(RoomDTO roomDTO) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(roomDTO.getRoomId());
        roomEntity.setRoomName(roomDTO.getRoomBirthdate());
        roomEntity.setRoomBirthdate(roomDTO.getRoomBirthdate());
        roomEntity.setRoomEmail(roomDTO.getRoomEmail());
        roomEntity.setOwnerCode(roomDTO.getOwnerCode());
        return roomEntity;
    }
}
