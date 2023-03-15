package com.project.BirthdayPostbox.repository;

import com.project.BirthdayPostbox.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, String> {

    Collection<MessageEntity> findByroom_id(String room_id);
}
