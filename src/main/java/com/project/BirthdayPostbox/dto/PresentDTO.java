package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.entity.PresentEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PresentDTO {
    private String presentId;
    private String presentSender;
    private String presentContent;
    private String presentImgUrl;
    private RoomDTO roomDTO;
    private String presentUrl;
}
