package com.rudgjs8080.student.service.impl;

import com.rudgjs8080.student.models.StudentVO;
import com.rudgjs8080.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stService")
public class StudentServiceImplV1 implements StudentService {
    @Override
    public List<StudentVO> selectAll() {
        return null;
    }

    @Override
    public StudentVO findById(String s) {
        return null;
    }

    @Override
    public void insert(StudentVO model) {

    }

    @Override
    public void update(StudentVO model) {

    }

    @Override
    public void delete(String s) {

    }

    /**
     * 학생정보를 추가(새로등록)할 때
     * 학번을 자동으로 생성하여 학생 model 객체를 생성한 후
     * Controller 에서  write.jsp 로 보내기
     */
    @Override
    public StudentVO insert() {
        StudentVO stVO = StudentVO.builder()
                .st_num("20210001")
                .build();
        return stVO;
    }
}
