package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.util.MessageDesign;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private String messageId;
    private String messageSender;
    private String messageContent;
    private RoomDTO roomDTO;
    private MessageDesign messageDesign;
}
