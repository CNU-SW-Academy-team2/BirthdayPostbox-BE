package com.project.BirthdayPostbox.repository;

import com.project.BirthdayPostbox.entity.Present;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentRepository extends JpaRepository<Present, String> {
}
