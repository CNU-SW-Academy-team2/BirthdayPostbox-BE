package com.project.BirthdayPostbox.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "present")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PresentEntity {
    @Id
    @Column(name = "present_id")
    private String presentId;

    @Column(name = "present_sender")
    private String presentSender;

    @Column(name = "present_content")
    private String presentContent;

    @Column(name = "present_img_url")
    private String presentImgUrl;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private RoomEntity room;
}
