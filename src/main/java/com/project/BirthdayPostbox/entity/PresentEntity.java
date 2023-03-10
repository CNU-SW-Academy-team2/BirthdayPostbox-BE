package com.project.BirthdayPostbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String presentId;
    private String roomId;
    private String presentSender;
    private String presentContent;
    private String presentImgUrl;

}
