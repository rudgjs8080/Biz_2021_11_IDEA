package com.rudgjs8080.student.service;

import com.rudgjs8080.student.models.StudentVO;

public interface StudentService extends GenericService<StudentVO, String>{

    public StudentVO insert();

}
