package com.project.BirthdayPostbox.repository;

import com.project.BirthdayPostbox.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, String> {

}
