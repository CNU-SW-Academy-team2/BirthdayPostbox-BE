package com.project.BirthdayPostbox.entity;
import com.project.BirthdayPostbox.dto.RoomDTO;

import com.project.BirthdayPostbox.util.MessageDesignCategory;
import com.project.BirthdayPostbox.util.PresentDesignCategory;
import com.project.BirthdayPostbox.util.RoomCategory;
import com.project.BirthdayPostbox.util.RoomDesign;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name ="room")
public class RoomEntity {
    @Id
    @Column(name = "room_id")
    private String id;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "room_birthdate")
    private Date roomBirthdate;
    @Column(name = "room_email")
    private String roomEmail;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "room_category")
    private RoomCategory roomCategory;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "room_design")
    private RoomDesign roomDesign;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "message_design_category")
    private MessageDesignCategory messageDesignCategory;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "present_design_category")
    private PresentDesignCategory presentDesignCategory;
    @Column(name = "owner_code")
    private String ownerCode;

    public static RoomEntity toSaveEntity(RoomDTO roomDTO) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(roomDTO.getRoomId());
        roomEntity.setRoomName(roomDTO.getRoomName());
        roomEntity.setRoomBirthdate(roomDTO.getRoomBirthdate());
        roomEntity.setRoomEmail(roomDTO.getRoomEmail());
        roomEntity.setOwnerCode(roomDTO.getOwnerCode());
        roomEntity.setRoomCategory(roomDTO.getRoomCategory());
        roomEntity.setRoomDesign(roomDTO.getRoomDesign());
        roomEntity.setMessageDesignCategory(roomDTO.getMessageDesignCategory());
        roomEntity.setPresentDesignCategory(roomDTO.getPresentDesignCategory());
        return roomEntity;
    }
}
