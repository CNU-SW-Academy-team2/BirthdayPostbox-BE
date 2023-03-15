package com.project.BirthdayPostbox.repository;

import com.project.BirthdayPostbox.entity.PresentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PresentRepository extends JpaRepository<PresentEntity, String> {
    Collection<PresentEntity> findByroom_id(String roomId);
}
