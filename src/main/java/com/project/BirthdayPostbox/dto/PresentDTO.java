package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.util.PresentDesign;
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
    private PresentDesign presentDesign;
}
