package com.worldhospital.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldhospital.app.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
