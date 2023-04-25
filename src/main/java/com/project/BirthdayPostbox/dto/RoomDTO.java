package com.project.BirthdayPostbox.dto;

import java.sql.Date;

import com.project.BirthdayPostbox.util.MessageDesignCategory;
import com.project.BirthdayPostbox.util.PresentDesignCategory;
import com.project.BirthdayPostbox.util.RoomCategory;
import com.project.BirthdayPostbox.util.RoomDesign;
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
    private RoomDesign roomDesign;
    private MessageDesignCategory messageDesignCategory;
    private PresentDesignCategory presentDesignCategory;
}
