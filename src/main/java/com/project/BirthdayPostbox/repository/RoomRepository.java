package com.project.BirthdayPostbox.repository;

import com.project.BirthdayPostbox.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;


@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, String> {

    int countByroomEmail(String email);

    Collection<RoomEntity> findByRoomBirthdate(Date birthDate);
}
