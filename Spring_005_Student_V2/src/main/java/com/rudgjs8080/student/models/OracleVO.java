package com.rudgjs8080.student.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class OracleVO {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long o_seq;
}
