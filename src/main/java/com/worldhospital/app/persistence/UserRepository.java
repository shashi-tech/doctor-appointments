package com.worldhospital.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldhospital.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
