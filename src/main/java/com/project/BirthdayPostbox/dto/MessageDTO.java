package com.project.BirthdayPostbox.dto;

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
}
