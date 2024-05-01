package com.mani.demoforJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mani.demoforJpa.Entity.student;

public interface studentRepo extends JpaRepository<student,Long>{

}
