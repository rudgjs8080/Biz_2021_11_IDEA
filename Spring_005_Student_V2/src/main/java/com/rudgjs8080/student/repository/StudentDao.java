package com.rudgjs8080.student.repository;

import com.rudgjs8080.student.models.StudentVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentVO,String> {

}
