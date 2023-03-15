package com.project.BirthdayPostbox.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

    @Id
    @Column(name = "message_id")
    private String messageId;

    @Column(name = "message_sender")
    private String messageSender;

    @Column(name = "message_content")
    private String messageContent;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private RoomEntity room;

}
